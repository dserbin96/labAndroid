package com.example.dns.labandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dns.labandroid.labFragmnet.OneLabActivity;
import com.example.dns.labandroid.labNetwork.LabNetworkJSONActivity;
import com.example.dns.labandroid.labSQL.LabSqlActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFragment = findViewById(R.id.btnFragmnet);
        Button btnNetworkJson = findViewById(R.id.btnNetworkJSON);
        Button btnSQL = findViewById(R.id.btnSQL);

        btnFragment.setOnClickListener(this);
        btnNetworkJson.setOnClickListener(this);
        btnSQL.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFragmnet:
                startActivity(new Intent(this, OneLabActivity.class));
                break;
            case R.id.btnSQL:
                startActivity(new Intent(this, LabSqlActivity.class));
                break;
            case R.id.btnNetworkJSON:
                startActivity(new Intent(this, LabNetworkJSONActivity.class));
                break;
        }
    }
}
