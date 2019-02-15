package com.example.dns.labandroid.labNetwork.four;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dns.labandroid.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collection;

public class FourNetworkActivity extends AppCompatActivity implements Response.Listener<String>,
        Response.ErrorListener {

    private FourAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_network);
        initRv();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://my-json-server.typicode.com/dserbin96/json/corpus";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, this, this);

        queue.add(stringRequest);

    }

    @Override
    public void onResponse(String response) {
        try {
            Collection<FourViewModel> listJson = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                int id = jsonArray.getJSONObject(i).getInt("id");
                String name = jsonArray.getJSONObject(i).getString("name");
                String url = jsonArray.getJSONObject(i).getString("url");
                listJson.add(new FourViewModel(id, name, url));
                adapter.setData(listJson);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void initRv() {
        RecyclerView rvExample = findViewById(R.id.rvFive);
        adapter = new FourAdapter();
        rvExample.setLayoutManager(new LinearLayoutManager(this));
        rvExample.setAdapter(adapter);
    }

}
