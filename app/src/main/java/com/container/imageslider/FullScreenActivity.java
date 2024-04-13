package com.container.imageslider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class FullScreenActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private int[] images = {
            R.drawable.xi1,
            R.drawable.xi2,
            R.drawable.xi3,
            R.drawable.xi4,
            R.drawable.xi5,
            R.drawable.xi6,
            R.drawable.xi7,
            R.drawable.xi8,
            R.drawable.xi9
    };

    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        viewPager = findViewById(R.id.viewPagerFullScreen);
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        int position = getIntent().getIntExtra("position", 0);
        FullScreenPagerAdapter adapter = new FullScreenPagerAdapter(images);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            viewPager.setScaleX(mScaleFactor);
            viewPager.setScaleY(mScaleFactor);
            return true;
        }
    }
}
