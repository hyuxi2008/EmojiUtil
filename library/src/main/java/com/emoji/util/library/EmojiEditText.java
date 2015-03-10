package com.emoji.util.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 能够显示自定义Emoji表情的EditText
 * Created by liujigang on 2015/3/9 0009.
 */
public class EmojiEditText extends EditText {
    //    public static String TAG = "Emoji_TAG";
    private boolean isCell = false;
    private Pattern mPattern;
    private EmojiUtil mEmojiUtil;
    private String mRegex = EmojiUtil.regex;

    public EmojiEditText(Context context) {
        super(context);
        init(context);
    }

    public EmojiEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EmojiEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EmojiEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mPattern = Pattern.compile(mRegex, Pattern.DOTALL);
        mEmojiUtil = new EmojiUtil(context);
    }

    /**
     * 如果有特有的匹配规则,可以对单个控件的正则进行替换匹配规则
     *
     * @param regex 对应正则
     */
    public void setRegex(String regex) {
        mRegex = regex;
        mPattern = Pattern.compile(regex, Pattern.DOTALL);
    }

    /**
     * 还在完善中
     *
     * @param s
     * @param start
     * @param before
     * @param count
     */
    public void onTextChanged1(CharSequence s, int start, int before, int count) {
        if (isCell)
            return;
        isCell = true;
        if (count > 1) {
//            setSelection(start + count - 1);
            Editable editableText = getEditableText();
            if (mPattern == null) {
                mPattern = Pattern.compile(mRegex, Pattern.DOTALL);
            }
            CharSequence charSequence = s.subSequence(start, start + count);
            Matcher ma = mPattern.matcher(charSequence);
            int i = 0;
            while (ma.find()) {
                String group = ma.group();
                editableText.replace(start + ma.start(), start + ma.start() + group.length(), mEmojiUtil.replace(group));
            }

        }
        isCell = false;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (isCell)
            return;
        isCell = true;
//        Log.i(TAG, s.toString() + "--" + start + "--" + before + "--" + count);
        if (count > 1) {
//            int selectionStart = mEditText.getSelectionStart();
            CharSequence end = null;
            if (start + count < s.length()) {
                end = s.subSequence(start + count, s.length());
            }

            this.setText(s.subSequence(0, start));
            CharSequence charSequence = s.subSequence(start, start + count);

            if (mPattern == null) {
                mPattern = Pattern.compile(mRegex, Pattern.DOTALL);
            }

            Matcher ma = mPattern.matcher(charSequence);
            int cStart = 0;
            while (ma.find()) {
                int start1 = ma.start();
                if (cStart < start1)
                    this.append(charSequence.subSequence(cStart, start1));
                String group = ma.group();
                cStart = start1 + group.length() + 1;

                this.append(mEmojiUtil.replace(group));
            }
            if (cStart < count) {
                this.append(charSequence.subSequence(cStart, count));
            } else if (cStart == 0) {
                this.append(charSequence);
            }
            if (end != null) {
                this.append(end);
                this.setSelection(start + count);
            } else {
                this.setSelection(this.length());
            }
        }
        isCell = false;
    }

    /**
     * 插入CharSequence
     *
     * @param where 从哪里开始插入
     * @param text  要插入的CharSequence
     */
    public void insert(int where, CharSequence text) {
        Editable edit = this.getEditableText();
        edit.insert(where, text);
    }

}
