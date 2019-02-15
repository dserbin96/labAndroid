package com.example.dns.labandroid.labNetwork.five;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dns.labandroid.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FiveAdapter extends RecyclerView.Adapter<FiveAdapter.ItemViewHolder> {

    private List<FiveViewModel> list;

    public FiveAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public FiveAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_five, parent, false);
        return new FiveAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FiveAdapter.ItemViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(Collection<FiveViewModel> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUser;
        private ImageView ivUser;

        ItemViewHolder(View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tvUser);
            ivUser = itemView.findViewById(R.id.ivUser);
        }

        public void bind(FiveViewModel model) {
            tvUser.setText(String.valueOf(model.getName()));
            Glide.with(itemView)
                    .load(model.getUrl())
                    .into(ivUser);
        }
    }

}
