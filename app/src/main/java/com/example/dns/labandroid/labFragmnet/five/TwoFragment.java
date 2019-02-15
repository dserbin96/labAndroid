package com.example.dns.labandroid.labFragmnet.five;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dns.labandroid.R;

public final class TwoFragment extends Fragment implements DrawableListener {

    private ImageView imageView;

    public static TwoFragment getInstance() {
        return new TwoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_drawable, container, false);
        imageView = view.findViewById(R.id.image);
        return view;
    }

    @Override
    public void drawable(@DrawableRes int drawable) {
        if (getContext() != null) {
            imageView.setBackgroundResource(drawable);
        }
    }
}
