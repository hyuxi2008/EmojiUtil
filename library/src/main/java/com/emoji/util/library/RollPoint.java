package com.emoji.util.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by liujigang on 2015/3/10 0010.
 */
public class RollPoint extends LinearLayout {

    private Drawable mDotNormal;
    private Drawable mDotSelected;
    private int mLastSelected = 0;

    public RollPoint(Context context) {
        super(context);
        initView();
    }

    public RollPoint(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public RollPoint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setPoint(
                new BitmapDrawable(getResources(), getRoundBitmap(getResources().getDimensionPixelOffset(R.dimen.point_radius),
                        0xffb3b3b3)),
                new BitmapDrawable(getResources(), getRoundBitmap(getResources().getDimensionPixelOffset(R.dimen.point_radius),
                        0xff3791ff)));
    }

    private Bitmap getRoundBitmap(int radius, int color) {
        Bitmap output = Bitmap.createBitmap(radius * 2, radius * 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, radius * 2, radius * 2);
        paint.setColor(color);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawCircle(radius, radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(output, rect, rect, paint);
        return output;
    }

    public void setPoint(Drawable dotNormal, Drawable dotSelected) {
        mDotNormal = dotNormal;
        mDotSelected = dotSelected;
    }

    public void setCount(int count) {
        for (int i = 0; i < count; i++) {
            ImageView imageView = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(getResources().getDimensionPixelSize(R.dimen.point_margin), 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
            if (i == 0) {
                imageView.setImageDrawable(mDotSelected);
            } else {
                imageView.setImageDrawable(mDotNormal);
            }
            addView(imageView);
        }
    }


    public void setSelected(int position) {
        if (position != mLastSelected) {
            ((ImageView) getChildAt(mLastSelected)).setImageDrawable(mDotNormal);
            ((ImageView) getChildAt(position)).setImageDrawable(mDotSelected);
            mLastSelected = position;
        }
    }


}
