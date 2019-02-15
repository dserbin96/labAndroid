package com.example.dns.labandroid.labNetwork.two;

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

public class TwoNetworkActivity extends AppCompatActivity implements Response.Listener<String>,
        Response.ErrorListener {

    private TextView tvTitle;
    private TextView tvPlashed;
    private ImageView ivImage;
    private TextView tvDescription;
    private TextView tvHistory;
    private ImageView ivFk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_network);

        initView();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://my-json-server.typicode.com/dserbin96/json/object";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, this, this);

        queue.add(stringRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(String response) {
        try {
            JSONObject jsonObj = new JSONObject(response).getJSONObject("arboretum");
            String title = jsonObj.getString("title");
            String plashad = jsonObj.getString("plashad");
            String description = jsonObj.getString("description");
            String history = jsonObj.getString("history");
            String image = jsonObj.getString("image");
            String imageScientist = jsonObj.getString("image_scientist");

            tvTitle.setText(title);
            tvPlashed.setText(plashad);
            Glide.with(this).load(image).into(ivImage);
            tvDescription.setText(description);
            tvHistory.setText(history);
            Glide.with(this).load(imageScientist).into(ivFk);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        tvTitle = findViewById(R.id.tvTitle);
        tvPlashed = findViewById(R.id.tvPlashed);
        ivImage = findViewById(R.id.ivImage);
        tvDescription = findViewById(R.id.tvDescription);
        tvHistory = findViewById(R.id.tvHistory);
        ivFk = findViewById(R.id.ivFk);
    }
}
