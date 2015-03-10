package com.emoji.util.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by liujigang on 2015/3/10 0010.
 */
public class EmojiView extends FrameLayout {
    private EmojiClickListener mListener;
    private int mSize = 21;
    private ViewPagerPagerAdapter mViewPagerPagerAdapter;

    public EmojiView(Context context) {
        super(context);
//        initView();
    }

    public EmojiView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        initView();
    }

    public EmojiView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        initView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EmojiView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void initView() {
        if (!EmojiUtil.isReady()) {
            Log.e("emoji", "EmojiUtil is not initialization");
            return;
        }
        removeAllViews();
        ViewPager viewPager = new ViewPager(getContext());
        viewPager.setLayoutParams(new ViewPager.LayoutParams());

        final RollPoint rollPoint = new RollPoint(getContext());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.BOTTOM;
        rollPoint.setLayoutParams(params);
        rollPoint.setOrientation(LinearLayout.HORIZONTAL);
        rollPoint.setGravity(Gravity.CENTER);
        rollPoint.setPadding(4, 4, 4, 4);
        rollPoint.setCount(EmojiUtil.emojiId.length / mSize + 1);

        mViewPagerPagerAdapter = new ViewPagerPagerAdapter(getContext(), viewPager, mListener, mSize);
        viewPager.setAdapter(mViewPagerPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                rollPoint.setSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        addView(viewPager);
        addView(rollPoint);
    }

    public void initView(EmojiClickListener l) {
        this.mListener = l;
        initView();
    }

    public void setOnEmojiItemClickListener(EmojiClickListener l) {
//        this.mListener = l;
//        if (mViewPagerPagerAdapter != null) {
//            mViewPagerPagerAdapter.setOnEmojiItemClickListener(l);
//        }
        initView(l);
    }

    public void setPageSize(int size) {
        mSize = size;
    }

}
