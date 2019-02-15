package com.example.dns.labandroid.labFragmnet.five;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.dns.labandroid.R;

public class VarOneFragmentActivity extends AppCompatActivity
        implements DrawableListener {

    public static final String KEY_DRAWABLE = "EY_DRAWABLE";

    private Fragment fragmentOne;
    private Fragment fragmentTwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_sql);
        initFragemnt();
    }

    @Override
    public void drawable(@ColorRes int colorRes) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ((DrawableListener) fragmentTwo).drawable(colorRes);
        } else {
            Intent intent = new Intent(this, DrawableActivity.class)
                    .putExtra(KEY_DRAWABLE, colorRes);
            startActivity(intent);
        }
    }

    private void initFragemnt() {
        fragmentOne = OneFragment.getInstance();
        fragmentTwo = TwoFragment.getInstance();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container1, fragmentOne)
                    .replace(R.id.container2, fragmentTwo)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,fragmentOne)
                    .commit();
        }
    }
}