package com.example.dns.labandroid.labNetwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dns.labandroid.R;
import com.example.dns.labandroid.labNetwork.example.ExNetworkActivity;
import com.example.dns.labandroid.labNetwork.five.FiveNetworkActivity;
import com.example.dns.labandroid.labNetwork.four.FourNetworkActivity;
import com.example.dns.labandroid.labNetwork.one.OneNetworkActivity;
import com.example.dns.labandroid.labNetwork.three.ThreeNetworkActivity;
import com.example.dns.labandroid.labNetwork.two.TwoNetworkActivity;

public class LabNetworkJSONActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_network);

        Button btnExample = findViewById(R.id.btnExample);
        Button btnOne = findViewById(R.id.btnOne);
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
                startActivity(new Intent(this, ExNetworkActivity.class));
                break;
            case R.id.btnOne:
                startActivity(new Intent(this, OneNetworkActivity.class));
                break;
            case R.id.btnTwo:
                startActivity(new Intent(this, TwoNetworkActivity.class));
                break;
            case R.id.btnThree:
                startActivity(new Intent(this, ThreeNetworkActivity.class));
                break;
            case R.id.btnFour:
                startActivity(new Intent(this, FourNetworkActivity.class));
                break;
            case R.id.btnFive:
                startActivity(new Intent(this, FiveNetworkActivity.class));
                break;
        }
    }

}
