package com.example.dns.labandroid.labFragmnet.one;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dns.labandroid.R;

public final class TwoFragment extends Fragment
        implements TextListener {

    private TextView tvText;

    public static TwoFragment getInstance() {
        return new TwoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_text, container, false);
        tvText = view.findViewById(R.id.tvText);
        return view;
    }

    @Override
    public void text(@StringRes int string) {
        tvText.setText(string);
    }
}
