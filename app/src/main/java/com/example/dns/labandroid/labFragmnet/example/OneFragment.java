package com.example.dns.labandroid.labFragmnet.example;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dns.labandroid.R;
//первый фрагмент с нужными цветами
public final class OneFragment extends Fragment implements View.OnClickListener {

    //прослушиватель с помощью которого будем поставлять цвета
    private ColorListener listener;

    public static OneFragment getInstance() {
        return new OneFragment();
    }

    //метод в котором предоставляется контекст активити в котром он былвызван
    //с помощью него фрагмент имеет связь с ативити
    //так как активити унаследовано от Context можно передовать его в наш фрагмент
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //проверяем расширяет ли ColorListener наше активити или нет
        //если не проверить может возникнуть ClassCastExaption
        if (context instanceof ColorListener) {
            //инициализируем наш прослушиватель
            listener = (ColorListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //создаем наш экран и инициализируем кнопки
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Button btnBlue = view.findViewById(R.id.btnBlue);
        Button btnGreen = view.findViewById(R.id.btnGreen);
        Button btnYellow = view.findViewById(R.id.btnYellow);
        Button btnRed = view.findViewById(R.id.btnRed);

        //в каждую кнопку заносим один прослушиватель
        //внутри него будет происходить переключение цвета по кнопкам
        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        btnGreen.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        //в зависимости от кнопки передаем прослушивателю цвет
        switch (v.getId()) {
            case R.id.btnBlue:
                listener.color(R.color.blue);
                break;
            case R.id.btnGreen:
                listener.color(R.color.green);
                break;
            case R.id.btnRed:
                listener.color(R.color.red);
                break;
            case R.id.btnYellow:
                listener.color(R.color.yellow);
                break;
        }
    }
}