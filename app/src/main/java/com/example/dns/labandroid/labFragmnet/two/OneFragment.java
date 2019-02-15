package com.example.dns.labandroid.labFragmnet.two;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dns.labandroid.R;

import java.util.ArrayList;
import java.util.Collection;

public final class OneFragment extends Fragment {

    private TextListener listener;
    private RecyclerView rvOne;
    private TextAdapter adapter;

    public static OneFragment getInstance() {
        return new OneFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TextListener) {
            listener = (TextListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_text, container, false);
        rvOne = view.findViewById(R.id.rvOne);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecycler();
        setData();
    }

    private void initRecycler() {
        adapter = new TextAdapter();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this.getContext(), 4);

        rvOne.setAdapter(adapter);
        rvOne.setLayoutManager(layoutManager);
        adapter.setListener(new TextAdapter.TextListener() {
            @Override
            public void onClick(int resId) {
                listener.text(getString(resId));
            }
        });
    }

    private void setData() {
        Collection<Integer> list = new ArrayList<>();
        list.add(R.string._0);
        list.add(R.string._1);
        list.add(R.string._2);
        list.add(R.string._3);
        list.add(R.string._4);
        list.add(R.string._5);
        list.add(R.string._6);
        list.add(R.string._7);
        list.add(R.string._8);
        list.add(R.string._9);

        adapter.fillData(list);
    }
}
