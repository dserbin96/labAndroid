package com.example.dns.labandroid.labFragmnet.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.dns.labandroid.R;

import static com.example.dns.labandroid.labFragmnet.example.LabFragmentActivity.KEY_COLOR;
/*Активиту внутри которого будет
  рисоваться наш второй фрагмент в портретном режиме*/
public class ColorActivity extends AppCompatActivity {

    /*создаем фрагмент глобальным и приватным для применения его во всем Activity*/
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        /*создаем фрагмент*/
        fragment = TwoFragment.getInstance();
        /*добавляем фрагмент в фрагмент менеджер для применения внутри Активити,
          теперь фрагмент будет помещен в контейнер с айдишником frame*/
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame, fragment)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        /*через намерение передаем цвет поступаемый из первого фрагмента*/
        int colorRes = getIntent().getIntExtra(KEY_COLOR, 0);
        /*добавляем во второй фрагмент назначенный цвет*/
        ((TwoFragment) fragment).color(colorRes);
    }
}
