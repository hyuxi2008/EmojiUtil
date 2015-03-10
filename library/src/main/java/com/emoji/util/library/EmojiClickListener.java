package com.emoji.util.library;

/**
 * Emoji表情点击监听
 * Created by liujigang on 2015/3/9 0009.
 */
public interface EmojiClickListener {
    /**
     * 被点击的条目的回调
     *
     * @param text 点击了那个图片,返回对应{@link com.emoji.util.library.EmojiUtil#emojiName} 的名称
     */
    void onClick(CharSequence text);
}
