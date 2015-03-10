package com.emoji.util.library;

import android.content.Context;
import android.text.Spannable;

/**
 * Emoji表情工具类
 * Created by liujigang on 2015/3/3 0003.
 */
public class EmojiUtil {

    private final Spannable.Factory spannableFactory;
    /**
     * 表情替换的正则
     */
    public static String regex = "\\[[^\\[\\]]+\\]";
    /**
     * 表情的对应的标示,顺序要和 {@link EmojiUtil#emojiId} 一一对应
     */
    public static String[] emojiName;
    /**
     * 表情的资源的ID, 顺序要和 {@link EmojiUtil#emojiName} 一一对应
     */
    public static int[] emojiId;
    private final Context context;
    private int mPercent = 2;

    public EmojiUtil(Context context) {
        this.context = context;
        spannableFactory = Spannable.Factory.getInstance();
    }

    /**
     * 设置图片的缩放比例,解决表情在{@link android.widget.TextView} {@link android.widget.EditText} 中显示过大的问题
     *
     * @param percent 缩放比例,原来的是现在的多少倍
     */
    public void setPercent(int percent) {
        mPercent = percent;
    }

    /**
     * 根据替换规则进行替换
     *
     * @param text 要替换的字符串
     * @return 源字符串或者替换后的字符串
     */
    public CharSequence replace(String text) {
        Spannable spannable = spannableFactory.newSpannable(text);
        int i = indexOfValue(text);
        if (i == -1)
            return text;
        spannable.setSpan(new EmojiSpan(context, emojiId[i], mPercent), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    /**
     * 判断当前 {@link EmojiUtil#emojiId} 和 {@link EmojiUtil#emojiName} 是否有效
     *
     * @return 有效:true,反之false
     */
    public static boolean isReady() {
        if (emojiName == null || emojiId == null || emojiId.length != emojiName.length) {
            return false;
        } else {
            return true;
        }
    }

    private int indexOfValue(String value) {
        for (int i = 0; i < emojiName.length; i++)
            if (emojiName[i].equals(value))
                return i;
        return -1;
    }
}
