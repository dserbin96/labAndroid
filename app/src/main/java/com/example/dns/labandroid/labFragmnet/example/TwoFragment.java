package com.example.dns.labandroid.labFragmnet.example;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.dns.labandroid.R;
//второй фрагмент где происходит отображение цвета с первого фрагмента
public final class TwoFragment extends Fragment implements ColorListener {

    private FrameLayout frameColor;

    //статический метод, с помощью которого создается сам фрагмент,
    //лучше прибегнуть к такому способу инициализации
    //можно с помощью конструктора создать фрагмент, но может случиться не хорошая ситуция
    //связанная с передачей параметров во фрагмент
    public static TwoFragment getInstance() {
        return new TwoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //добавляем во фрагмент верстку
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        //инициализируем контейнер внутри фрагмента
        frameColor = view.findViewById(R.id.frameColor);
        return view;
    }

    @Override
    public void color(@ColorRes int color) {
        if (getContext() != null) {
            //задаем фон нашему фрагменту с выбранным цветом
            frameColor.setBackgroundColor(ContextCompat.getColor(getContext(), color));
        }
    }
}
