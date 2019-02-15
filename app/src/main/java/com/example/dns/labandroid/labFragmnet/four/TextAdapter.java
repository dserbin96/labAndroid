package com.example.dns.labandroid.labFragmnet.four;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dns.labandroid.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ItemViewHolder> {

    private List<Integer> listText;
    private TextAdapter.TextListener textListener;

    public TextAdapter() {
        listText = new ArrayList<>();
    }

    @NonNull
    @Override
    public TextAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
        return new TextAdapter.ItemViewHolder(view, textListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TextAdapter.ItemViewHolder holder, int position) {
        holder.bind(listText.get(position));
    }

    @Override
    public int getItemCount() {
        return listText.size();
    }

    public void setListener(TextAdapter.TextListener listener) {
        this.textListener = listener;
    }

    public void fillData(Collection<Integer> list) {
        this.listText.clear();
        this.listText.addAll(list);
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private TextView textView;
        private TextAdapter.TextListener listener;
        private int idRes = 0;

        ItemViewHolder(View itemView, TextAdapter.TextListener listener) {
            super(itemView);
            this.listener = listener;
            textView = itemView.findViewById(R.id.itemText);
        }

        public void bind(@StringRes int idRes) {
            this.idRes = idRes;
            textView.setText(idRes);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(idRes);
        }
    }

    public interface TextListener {
        void onClick(@StringRes int resId);
    }
}
