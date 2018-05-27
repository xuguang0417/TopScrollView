package com.xg.scrollviewdemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created on 2018/5/27.
 *
 * @author xuguang
 */
public class TestActivity extends AppCompatActivity {

    private View mStickyView2;
    private StickyScrollView mStickyScrollView;
    private View mPlaceholderView2;

    private StickyScrollViewCallbacks mCallbacks2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mStickyScrollView = (StickyScrollView)findViewById(R.id.scroll_view);
        mStickyView2 = findViewById(R.id.sticky2);

        mPlaceholderView2 = findViewById(R.id.placeholder2);

        mCallbacks2 = new StickyScrollViewCallbacks(mStickyView2, mPlaceholderView2,
                mStickyScrollView);

        mStickyView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestActivity.this, R.string.app_name, Toast.LENGTH_SHORT).show();
            }
        });

        mStickyScrollView.addCallbacks(mCallbacks2);
        mStickyScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                new StickyScrollViewGlobalLayoutListener(mCallbacks2));
    }
}
