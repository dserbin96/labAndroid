package com.example.dns.labandroid.labFragmnet.three;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.dns.labandroid.R;

import static com.example.dns.labandroid.labFragmnet.four.VarTwoFragmentActivity.KEY_STRING;

public class TextActivity extends AppCompatActivity {

    TwoFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        fragment = TwoFragment.getInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame, fragment)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        int stringRes = getIntent().getIntExtra(KEY_STRING, 0);
        fragment.text(stringRes);
    }
}
