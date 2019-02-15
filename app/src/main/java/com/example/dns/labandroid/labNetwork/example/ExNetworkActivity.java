package com.example.dns.labandroid.labNetwork.example;

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

//todo в манифесте разрешение!!!!!!!
//активити внутри которого происходят запросы в сеть
//расширяем активити прослушивателями для приема ответа с сервера
public class ExNetworkActivity extends AppCompatActivity implements Response.Listener<String>,
        Response.ErrorListener {

    //адаптер для заполнения ресайклера
    private ExAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_network);
        //инициализируем ресайклер
        initRv();

        //создаем очередь ля запросов в сеть
        RequestQueue queue = Volley.newRequestQueue(this);
        //урл на который идет запрос
        String url = "https://my-json-server.typicode.com/dserbin96/json/schedule";

        //Строковый запрос с параметрами
        //в первом указываем тип запроса:GET,POST,PUT и т.д
        //во втором урл куда происходит запрос
        //в третьем успешный исход запроса
        //в четвертом ошибка запроса
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, this, this);

        //добавляем в очередь запрос
        queue.add(stringRequest);

    }

    //удачный исход запроса
    @Override
    public void onResponse(String response) {
        //в ответе получаем строку в которой находится информация формата JSON
        try {
            //создаем коллекцию внутри котрой находится модель предоставляемая в адаптер
            Collection<ExViewModel> listJson = new ArrayList<>();
            //конвертируем строку в объект JSONArray
            JSONArray jsonArray = new JSONArray(response);
            //проходимся по каждодму элементу
            for (int i = 0; i < jsonArray.length(); i++) {
                //по заданным полям парсим в нужный нам тип элементы
                int id = jsonArray.getJSONObject(i).getInt("id");
                String teacher = jsonArray.getJSONObject(i).getString("teacher");
                String cabinet = jsonArray.getJSONObject(i).getString("cabinet");
                String time = jsonArray.getJSONObject(i).getString("time");
                //получившиеся данные добавляем в массив
                listJson.add(new ExViewModel(id, cabinet, teacher, time));
                //добавляем в адаптер данные
                adapter.setData(listJson);
            }
        } catch (JSONException e) {
            //в случае возниковения ошибки конвертации выводим стэк с ошибками
            e.printStackTrace();
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        //при неудачном запросе в сеть выводим сообщение
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    //инициализируем ресайклер
    private void initRv() {
        //находим его в верстке
        RecyclerView rvExample = findViewById(R.id.rvExample);
        //инициализируем адаптер
        adapter = new ExAdapter();
        //передаем ему лэйаут мэнеджер
        //лэейаут мэнеджер ответсвенен за отображение ресайклера
        //LinearLayoutManaget отображает в лининию список с элементами
        //по умолчанию задан вертикально
        rvExample.setLayoutManager(new LinearLayoutManager(this));
        //добавляем адаптер в ресайклер
        rvExample.setAdapter(adapter);
    }

}
