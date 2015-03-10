package com.emoji.util.library;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by liujigang on 2015/3/9 0009.
 */
public class ViewPagerPagerAdapter extends PagerAdapter {

    private final Context mContext;
    private final ViewGroup mViewGroup;
    private final int mSize;
    private EmojiClickListener mListener;
    private GridViewInstance mGridViewInstance;

    public ViewPagerPagerAdapter(Context context, ViewGroup root, EmojiClickListener listener, int size) {
        super();
        mContext = context;
        mViewGroup = root;
        mListener = listener;
        mSize = size;
//        mGridViewInstance = new GridViewInstance(context);
    }

    @Override
    public int getCount() {
        return 1 + EmojiUtil.emojiId.length / mSize;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        GridView gridView = new GridViewInstance(mContext).newInstance(R.layout.emoji_gridview, mViewGroup, false, position, mSize, mListener);
        container.addView(gridView);
        return gridView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void setOnEmojiItemClickListener(EmojiClickListener l) {
        mListener = l;
        if (mGridViewInstance != null) {
            mGridViewInstance.setOnEmojiItemClickListener(l);
        }
    }
}
