package com.example.dns.labandroid.labNetwork.three;

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

public class ThreeNetworkActivity extends AppCompatActivity implements Response.Listener<String>,
        Response.ErrorListener {

    private TextView tvTitle;
    private TextView tvHistory;
    private ImageView ivImage;
    private TextView tvName;
    private TextView tvTraining;
    private TextView tvComposition;
    private ImageView ivFk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_network);

        tvTitle = findViewById(R.id.tvTitle);
        tvHistory = findViewById(R.id.tvHistory);
        ivImage = findViewById(R.id.ivImage);
        tvName = findViewById(R.id.tvName);
        tvTraining = findViewById(R.id.tvTraining);
        tvComposition = findViewById(R.id.tvComposition);
        ivFk = findViewById(R.id.ivFk);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://my-json-server.typicode.com/dserbin96/json/object";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, this, this);

        queue.add(stringRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(String response) {
        try {
            JSONObject jsonObj = new JSONObject(response).getJSONObject("department");
            String title = jsonObj.getString("title");
            String history = jsonObj.getString("history");
            String image = jsonObj.getString("image");
            String name = jsonObj.getString("name");
            String trainingDirection = jsonObj.getString("training_direction");
            String composition = jsonObj.getString("composition");
            String imageFk = jsonObj.getString("image_fk");

            tvTitle.setText(title);
            tvHistory.setText(history);
            Glide.with(this).load(image).into(ivImage);
            tvName.setText(name);
            tvTraining.setText(trainingDirection);
            tvComposition.setText(composition);
            Glide.with(this).load(imageFk).into(ivFk);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
