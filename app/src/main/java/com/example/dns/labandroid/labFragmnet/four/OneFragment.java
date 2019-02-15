package com.example.dns.labandroid.labFragmnet.four;

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
                listener.text(resId);
            }
        });
    }

    private void setData() {
        Collection<Integer> list = new ArrayList<>();
        list.add(R.string.A);
        list.add(R.string.B);
        list.add(R.string.C);
        list.add(R.string.D);
        list.add(R.string.E);
        list.add(R.string.F);
        list.add(R.string.G);
        list.add(R.string.H);
        list.add(R.string.I);
        list.add(R.string.J);
        list.add(R.string.K);
        list.add(R.string.L);
        list.add(R.string.M);
        list.add(R.string.N);
        list.add(R.string.O);
        list.add(R.string.P);
        list.add(R.string.Q);
        list.add(R.string.R);
        list.add(R.string.S);
        list.add(R.string.T);
        list.add(R.string.U);
        list.add(R.string.V);
        list.add(R.string.W);
        list.add(R.string.X);
        list.add(R.string.Y);
        list.add(R.string.Z);
        adapter.fillData(list);
    }
}
