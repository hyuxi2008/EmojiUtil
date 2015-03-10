package com.emoji.util.library;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import android.util.Log;

public class EmojiSpan extends DynamicDrawableSpan {

    private final Context mContext;
    private final int mResourceId;
    private int mPercent = 2;

    public EmojiSpan(Context context, int resourceId) {
        super(ALIGN_BOTTOM);
        mContext = context;
        mResourceId = resourceId;
    }

    public EmojiSpan(Context context, int resourceId, int percent) {
        super(ALIGN_BOTTOM);
        mContext = context;
        mResourceId = resourceId;
        this.mPercent = percent;
    }

    @Override
    public Drawable getDrawable() {
        Drawable drawable = null;
        try {
            drawable = mContext.getResources().getDrawable(mResourceId);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth() / mPercent,
                    drawable.getIntrinsicHeight() / mPercent);
        } catch (Exception e) {
            Log.e("sms", "Unable to find resource: " + mResourceId);
        }
        return drawable;
    }
}
