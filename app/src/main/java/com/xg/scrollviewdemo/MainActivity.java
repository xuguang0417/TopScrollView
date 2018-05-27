package com.xg.scrollviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mStickyView;

    private View mPlaceholderView;

    private StickyScrollView mStickyScrollView;

    private StickyScrollViewCallbacks mCallbacks;

    private View mStickyView2;

    private View mPlaceholderView2;

    private StickyScrollViewCallbacks mCallbacks2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStickyScrollView = (StickyScrollView)findViewById(R.id.scroll_view);
        mStickyView = (TextView)findViewById(R.id.sticky);
        mPlaceholderView = findViewById(R.id.placeholder);

        mStickyView2 = findViewById(R.id.sticky2);
        mPlaceholderView2 = findViewById(R.id.placeholder2);

        mCallbacks = new StickyScrollViewCallbacks(mStickyView, mPlaceholderView,
                mPlaceholderView2, mStickyScrollView);

        mStickyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean enableSticky = mCallbacks.getEnableSticky();
                mCallbacks.setEnableSticky(!enableSticky);
                if (enableSticky) {
                    mStickyView.setText(R.string.start_sticky);
                } else {
                    mStickyView.setText(R.string.stop_sticky);
                }
            }
        });

        mStickyScrollView.addCallbacks(mCallbacks);

        mStickyScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                new StickyScrollViewGlobalLayoutListener(mCallbacks));

        mCallbacks2 = new StickyScrollViewCallbacks(mStickyView2, mPlaceholderView2,
                mStickyScrollView);

        mStickyView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.app_name, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });

        mStickyScrollView.addCallbacks(mCallbacks2);
        mStickyScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                new StickyScrollViewGlobalLayoutListener(mCallbacks2));
    }
}
