package com.example.dns.labandroid.labNetwork.one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.dns.labandroid.R;

import org.json.JSONException;
import org.json.JSONObject;

public class OneNetworkActivity extends AppCompatActivity implements Response.Listener<String>,
        Response.ErrorListener {

    private ImageView image;
    private TextView title;
    private TextView titleInternal;
    private TextView motto;
    private TextView year;
    private TextView students;
    private ImageView ivRector;
    private TextView rector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_network);

        initView();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://my-json-server.typicode.com/dserbin96/json/object";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, this, this);

        queue.add(stringRequest);

    }

    @Override
    public void onResponse(String response) {
        try {
            JSONObject jsonObj = new JSONObject(response).getJSONObject("university");
            String url = jsonObj.getString("url");
            String title = jsonObj.getString("title");
            String internationalTitle = jsonObj.getString("international_title");
            String motto = jsonObj.getString("motto");
            int year = jsonObj.getInt("year");
            int students = jsonObj.getInt("students");
            String rectorName = jsonObj.getString("rector_name");
            String rectorUrl = jsonObj.getString("rector_url");

            Glide.with(this).load(url).into(image);
            this.title.setText(this.title.getText() + title);
            this.titleInternal.setText(this.titleInternal.getText() + internationalTitle);
            this.motto.setText(this.motto.getText() + motto);
            this.year.setText(this.year.getText() + String.valueOf(year));
            this.students.setText(this.students.getText() + String.valueOf(students));
            this.rector.setText(this.rector.getText() + rectorName);
            Glide.with(this).load(rectorUrl).into(ivRector);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        image = findViewById(R.id.image);
        title = findViewById(R.id.title);
        titleInternal = findViewById(R.id.titleInternal);
        motto = findViewById(R.id.motto);
        year = findViewById(R.id.year);
        students = findViewById(R.id.students);
        ivRector = findViewById(R.id.ivRector);
        rector = findViewById(R.id.rector);
    }

}