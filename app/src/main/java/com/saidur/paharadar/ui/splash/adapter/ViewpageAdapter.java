package com.saidur.paharadar.ui.splash.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewpageAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    private int[] layouts;


    public ViewpageAdapter() {

    }


    @Override
    public int getCount() {
        return layouts.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
