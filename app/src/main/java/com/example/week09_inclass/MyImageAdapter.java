package com.example.week09_inclass;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyImageAdapter extends BaseAdapter {
    private Context context; // main activity’s context
    Integer[] smallImages; // thumbnail data set
    public MyImageAdapter(Context mainActivityContext, Integer[] thumbnails) { context = mainActivityContext; smallImages = thumbnails; }

    @Override
    public int getCount() {
        return smallImages.length;
    }

    @Override
    public Object getItem(int i) {
        return smallImages[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view==null) {
            imageView = new ImageView(context);
            int gridsize = context.getResources().getDimensionPixelOffset(R.dimen.gridview_size);
            imageView.setLayoutParams(new GridView.LayoutParams(gridsize, gridsize)); imageView.setScaleType(ImageView.ScaleType.FIT_XY); imageView.setPadding(5, 5, 5, 5);
        }
        else { imageView = (ImageView) view; }
        imageView.setImageResource(smallImages[i]);
        imageView.setBackgroundResource(R.drawable.item_border);
        imageView.setPadding(50,10,50,10);
        imageView.setId(i);
        return imageView;
    }
}
