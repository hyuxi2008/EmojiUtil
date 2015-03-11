package com.emoji.util.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

/**
 * Created by liujigang on 2015/3/9 0009.
 */
public class GridViewInstance implements AdapterView.OnItemClickListener, Cloneable {

    private final Context mContext;
    private EmojiClickListener mListener;
    private int mPosition;
    private int mSize;

    public GridViewInstance(Context context) {
        this.mContext = context;
    }

    public GridView newInstance(int resource, ViewGroup root, boolean attachToRoot, int position, int size, EmojiClickListener listener) {
        this.mListener = listener;
        this.mPosition = position;
        this.mSize = size;
        LayoutInflater factory = LayoutInflater.from(mContext);
        GridView gridview = (GridView) factory.inflate(resource, root, attachToRoot);
        initGridView(gridview);
        return gridview;
    }

    private void initGridView(GridView gridview) {
        gridview.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                int count = EmojiUtil.emojiId.length - mPosition * mSize;
                if (count > mSize)
                    count = mSize;
                return count;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.emoji_item, parent, false);
                convertView.setBackgroundResource(EmojiUtil.emojiId[position + mPosition * mSize]);
                return convertView;
            }
        });
        gridview.setOnItemClickListener(this);
    }

    public void setOnEmojiItemClickListener(EmojiClickListener l) {
        this.mListener = l;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mListener != null) {
            mListener.onClick(EmojiUtil.emojiName[position + mPosition * mSize]);
        }

    }
    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
