package com.example.dns.labandroid.labFragmnet.three;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.dns.labandroid.R;

public class VarFourFragmentActivity extends AppCompatActivity
        implements TextListener {

    public static final String KEY_STRING = "KEY_STRING";

    private Fragment fragmentOne;
    private Fragment fragmentTwo;


    private static final int MODE_TEXT = 0;
    private SharedPreferences preferences;
    private static final String KEY_TEXT = "KEY_TEXT";
    private int key = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_var_two_fragment);
        initFragemnt();
        initPref();
    }

    @Override
    public void text(@StringRes int stringRes) {
        key += Integer.parseInt(getString(stringRes));
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ((TextListener) fragmentTwo).text(key);
        } else {
            Intent intent = new Intent(this, TextActivity.class)
                    .putExtra(KEY_STRING, key);
            startActivity(intent);
        }
        preferences.edit().putInt(KEY_TEXT, key).apply();
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

    private void initPref() {
        preferences = getPreferences(MODE_TEXT);
        key = preferences.getInt(KEY_TEXT, 0);
    }
}