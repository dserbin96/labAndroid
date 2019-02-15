package com.example.dns.labandroid.labNetwork.example;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dns.labandroid.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//адаптер для отрисовки элементов списке ресайклера
public class ExAdapter extends RecyclerView.Adapter<ExAdapter.ItemViewHolder> {

    //список с моделью передаваемой в наш элемент
    //внутри модели находиться информация заполняемая элементом
    private List<ExViewModel> list;

    public ExAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ExAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //создаем вид нашего элемента и передаем его в сам элемент
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_example, parent, false);
        return new ExAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExAdapter.ItemViewHolder holder, int position) {
        //заполняем элемент с помощью модели из списка
        holder.bind(list.get(position));
    }

    //колличество элементов в адаптере
    @Override
    public int getItemCount() {
        return list.size();
    }

    //метод для внемения данных в адаптер
    public void setData(Collection<ExViewModel> list) {
        //очищаем список
        this.list.clear();
        //заполняем новыми данными список
        this.list.addAll(list);
        //обновляем полностью наш адаптер
        //при обновлении перезаполняется каждый элемент
        notifyDataSetChanged();
    }

    //класс который явлется элементом списка,
    //в него передается модель с данными об элемете из списка
    static class ItemViewHolder extends RecyclerView.ViewHolder {

        //все поля элемента списка
        private TextView tvNumber;
        private TextView tvTeacher;
        private TextView tvCabinet;
        private TextView tvTime;

        //передаем верску в холдер
        ItemViewHolder(View itemView) {
            super(itemView);

            //инициализируем поля
            tvNumber = itemView.findViewById(R.id.tvNumber);
            tvTeacher = itemView.findViewById(R.id.tvTeacher);
            tvCabinet = itemView.findViewById(R.id.tvCabinet);
            tvTime = itemView.findViewById(R.id.tvTime);
        }

        //заполняем поля
        public void bind(ExViewModel model) {
            tvNumber.setText(String.valueOf(model.getId()));
            tvTeacher.setText(model.getTeacher());
            tvCabinet.setText(String.valueOf(model.getCabinet()));
            tvTime.setText(model.getTime());
        }
    }

}
