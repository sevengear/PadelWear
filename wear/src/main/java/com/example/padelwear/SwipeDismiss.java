package com.example.padelwear;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.wear.widget.SwipeDismissFrameLayout;
import android.support.wearable.activity.WearableActivity;

/**
 * Created by Miguel Á. Núñez on 13/05/2018.
 */
public class SwipeDismiss extends WearableActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_dismiss);
        SwipeDismissFrameLayout root = findViewById(R.id.swipe_dismiss_root);
        root.addCallback(new SwipeDismissFrameLayout.Callback() {
            @Override
            public void onDismissed(SwipeDismissFrameLayout layout) {
                finish();
            }
        });
    }
}
