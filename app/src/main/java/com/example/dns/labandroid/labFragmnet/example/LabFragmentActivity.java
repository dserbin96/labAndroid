package com.example.dns.labandroid.labFragmnet.example;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.dns.labandroid.R;
/*актививити в котором происходит взаимодействие между двумя фрагментами*/
public class LabFragmentActivity extends AppCompatActivity
        implements ColorListener {

    public static final String KEY_COLOR = "KEY_COLOR";

    //первый фрагмент
    private Fragment fragmentOne;
    //второй фрагмент
    private Fragment fragmentTwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_sql);
        //инициализируем фрагменты
        initFragemnt();
    }

    @Override
    public void color(@ColorRes int colorRes) {
        //в зависимости от ориентации происходит внесение цвета во второй фрагмент
        //если альбомный режим добавляем фрагмент в активити
        //если портретный создаем активити с нужным цветом
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ((ColorListener) fragmentTwo).color(colorRes);
        } else {
            Intent intent = new Intent(this, ColorActivity.class)
                    .putExtra(KEY_COLOR, colorRes);
            startActivity(intent);
        }
    }

    private void initFragemnt() {
        //создаем фрагменты
        fragmentOne = OneFragment.getInstance();
        fragmentTwo = TwoFragment.getInstance();
        //в зависимости от ориентации добавляем фрагменты в контейнеры,
        //с учетом различной верстки будет происходить разная отрисовка
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container1, fragmentOne)
                    .replace(R.id.container2, fragmentTwo)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, OneFragment.getInstance())
                    .commit();
        }
    }
}