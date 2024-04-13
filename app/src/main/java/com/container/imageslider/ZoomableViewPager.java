package com.container.imageslider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class ZoomableViewPager extends ViewPager {

    public ZoomableViewPager(Context context) {
        super(context);
    }

    public ZoomableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // Disable touch events for the ViewPager
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // Disable intercepting touch events for the ViewPager
        return false;
    }
}
