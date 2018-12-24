package com.borodin.moneytracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Item> data = new ArrayList<>();

//    public ItemsAdapter() {
//        createData();
//    }

    public void setData(List<Item> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder viewHolder, int i) {
        Item record = data.get(i);
        viewHolder.applyData(record);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addItem(Item item) {
        data.add(item);
        notifyItemInserted(data.size());
    }

//    private void createData() {
//        data.add(new Item("Молоко", 35));
//        data.add(new Item("Жизнь", 1));
//        data.add(new Item("Курсы", 50));
//        data.add(new Item("Хлеб", 26));
//        data.add(new Item("Тот самый ужин, который я оплатил за всех, потому что платил картой", 60000));
//        data.add(new Item("", 604));
//        data.add(new Item("Ракета Falcon Heavy", 1));
//        data.add(new Item("Лего тысячилетний сокол", 1000000000));
//        data.add(new Item("Монитор", 100));
//        data.add(new Item("MacBook Pro", 100));
//        data.add(new Item("Шоколадка", 100));
//        data.add(new Item("Шкаф", 100));
//    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void applyData(Item item) {
            title.setText(item.name);

            //String priceText = String.format((String) getResources().getString(R.string.price_format), record.getPrice());
            //price.setText(priceText);
            price.setText(item.price);
        }
    }
}
