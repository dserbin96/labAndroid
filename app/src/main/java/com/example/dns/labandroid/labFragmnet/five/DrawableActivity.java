package com.example.dns.labandroid.labFragmnet.five;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.dns.labandroid.R;

import static com.example.dns.labandroid.labFragmnet.five.VarOneFragmentActivity.KEY_DRAWABLE;

public class DrawableActivity extends AppCompatActivity {

    Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        fragment = TwoFragment.getInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame, fragment)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        int colorRes = getIntent().getIntExtra(KEY_DRAWABLE, 0);
        ((DrawableListener)fragment).drawable(colorRes);
    }
}
