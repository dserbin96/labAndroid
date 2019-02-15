package com.example.dns.labandroid.labNetwork.four;

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

public class FourAdapter extends RecyclerView.Adapter<FourAdapter.ItemViewHolder> {

    private List<FourViewModel> list;

    public FourAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public FourAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_four, parent, false);
        return new FourAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FourAdapter.ItemViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(Collection<FourViewModel> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUser;
        private ImageView ivUser;
        private TextView tvNumber;

        ItemViewHolder(View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tvUser);
            tvNumber = itemView.findViewById(R.id.tvNumber);
            ivUser = itemView.findViewById(R.id.ivUser);
        }

        public void bind(FourViewModel model) {
            tvNumber.setText(String.valueOf(model.getId()));
            tvUser.setText(model.getName());
            Glide.with(itemView)
                    .load(model.getUrl())
                    .into(ivUser);
        }
    }

}
