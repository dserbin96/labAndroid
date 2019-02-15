package com.example.dns.labandroid.labFragmnet.four;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.dns.labandroid.R;

public class VarTwoFragmentActivity extends AppCompatActivity
        implements TextListener {

    public static final String KEY_STRING = "KEY_STRING";

    private Fragment fragmentOne;
    private Fragment fragmentTwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_var_two_fragment);
        initFragemnt();
    }

    @Override
    public void text(@StringRes int stringRes) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ((TextListener) fragmentTwo).text(stringRes);
        } else {
            Intent intent = new Intent(this, TextActivity.class)
                    .putExtra(KEY_STRING, stringRes);
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
                    .replace(R.id.container, OneFragment.getInstance())
                    .commit();
        }
    }
}