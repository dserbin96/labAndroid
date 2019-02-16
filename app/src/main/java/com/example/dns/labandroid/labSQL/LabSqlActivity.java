package com.example.dns.labandroid.labSQL;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dns.labandroid.R;
import com.example.dns.labandroid.labSQL.example.ExCreateActivity;
import com.example.dns.labandroid.labSQL.five.FiveCreateActivity;
import com.example.dns.labandroid.labSQL.four.FourCreateActivity;
import com.example.dns.labandroid.labSQL.one.OneCreateActivity;
import com.example.dns.labandroid.labSQL.three.ThreeCreateActivity;
import com.example.dns.labandroid.labSQL.two.TwoCreateActivity;

public class LabSqlActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_sql);

        Button btnOne = findViewById(R.id.btnOne);
        Button btnExample = findViewById(R.id.btnExample);
        Button btnTwo = findViewById(R.id.btnTwo);
        Button btnThree = findViewById(R.id.btnThree);
        Button btnFour = findViewById(R.id.btnFour);
        Button btnFive = findViewById(R.id.btnFive);

        btnExample.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnExample:
                startActivity(new Intent(this, ExCreateActivity.class));
                break;
            case R.id.btnOne:
                startActivity(new Intent(this, OneCreateActivity.class));
                break;
            case R.id.btnTwo:
                startActivity(new Intent(this, TwoCreateActivity.class));
                break;
            case R.id.btnThree:
                startActivity(new Intent(this, ThreeCreateActivity.class));
                break;
            case R.id.btnFour:
                startActivity(new Intent(this, FourCreateActivity.class));
                break;
            case R.id.btnFive:
                startActivity(new Intent(this, FiveCreateActivity.class));
                break;
        }
    }
}