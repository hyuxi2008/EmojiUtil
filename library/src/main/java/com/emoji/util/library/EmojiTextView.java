package com.emoji.util.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liujigang on 2015/3/10 0010.
 */
public class EmojiTextView extends TextView {

    private Pattern mPattern;
    private EmojiUtil mEmojiUtil;
    private String mRegex = EmojiUtil.regex;

    public EmojiTextView(Context context) {
        super(context);
        init();
    }

    public EmojiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        String text = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        if (!TextUtils.isEmpty(text)) {
            setEmojiText(text);
        }
    }

    public EmojiTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        String text = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        if (!TextUtils.isEmpty(text)) {
            setEmojiText(text);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EmojiTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        String text = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        if (!TextUtils.isEmpty(text)) {
            setEmojiText(text);
        }
    }

    private void init() {
        mPattern = Pattern.compile(mRegex, Pattern.DOTALL);
        mEmojiUtil = new EmojiUtil(getContext());
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
     * 设置Emoji表情
     *
     * @param text 要插入的字符
     */
    public final void setEmojiText(CharSequence text) {
        setText("");
        if (text == null || text.length() == 0) {
            return;
        }
        Matcher ma;
        if (mPattern == null) {
            mPattern = Pattern.compile(mRegex, Pattern.DOTALL);
        }
        ma = mPattern.matcher(text);
        int lastPosition = 0;
        while (ma.find()) {
            append(text.subSequence(lastPosition, ma.start()));
            String group = ma.group();
            append(mEmojiUtil.replace(group));
            lastPosition = ma.start() + group.length();
        }
        if (lastPosition < text.length()) {
            append(text.subSequence(lastPosition, text.length()));
        }
    }

}
