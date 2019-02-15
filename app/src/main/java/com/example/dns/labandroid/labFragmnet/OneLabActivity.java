package com.example.dns.labandroid.labFragmnet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dns.labandroid.R;
import com.example.dns.labandroid.labFragmnet.example.LabFragmentActivity;
import com.example.dns.labandroid.labFragmnet.five.VarOneFragmentActivity;
import com.example.dns.labandroid.labFragmnet.four.VarTwoFragmentActivity;
import com.example.dns.labandroid.labFragmnet.one.VarThreeFragmentActivity;
import com.example.dns.labandroid.labFragmnet.three.VarFourFragmentActivity;
import com.example.dns.labandroid.labFragmnet.two.VarFiveFragmentActivity;

public class OneLabActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_lab);

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
                startActivity(new Intent(this, LabFragmentActivity.class));
                break;
            case R.id.btnOne:
                startActivity(new Intent(this, VarOneFragmentActivity.class));
                break;
            case R.id.btnTwo:
                startActivity(new Intent(this, VarTwoFragmentActivity.class));
                break;
            case R.id.btnThree:
                startActivity(new Intent(this, VarThreeFragmentActivity.class));
                break;
            case R.id.btnFour:
                startActivity(new Intent(this, VarFourFragmentActivity.class));
                break;
            case R.id.btnFive:
                startActivity(new Intent(this, VarFiveFragmentActivity.class));
                finish();
                break;
        }
    }
}
