package com.example.dns.labandroid.labFragmnet.five;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dns.labandroid.R;

public final class OneFragment extends Fragment implements View.OnClickListener {

    private DrawableListener listener;

    public static OneFragment getInstance() {
        return new OneFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DrawableListener) {
            listener = (DrawableListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_drawable, container, false);
        ImageView ivOne = view.findViewById(R.id.ivOne);
        ImageView ivTwo = view.findViewById(R.id.ivTwo);
        ImageView ivThree = view.findViewById(R.id.ivThree);
        ImageView ivFour = view.findViewById(R.id.ivFour);

        ivOne.setOnClickListener(this);
        ivTwo.setOnClickListener(this);
        ivThree.setOnClickListener(this);
        ivFour.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivOne:
                listener.drawable(R.drawable.image_one);
                break;
            case R.id.ivTwo:
                listener.drawable(R.drawable.image_two);
                break;
            case R.id.ivThree:
                listener.drawable(R.drawable.image_three);
                break;
            case R.id.ivFour:
                listener.drawable(R.drawable.image_four);
                break;
        }
    }
}