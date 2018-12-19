package com.borodin.moneytracker;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemListActivity extends AppCompatActivity {
    private RecyclerView recycleView;
    private List<Record> data = new ArrayList<>();
    private static final int VerticalSpaceSize = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        recycleView = findViewById(R.id.list);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.addItemDecoration(new VerticalSpaceItemDecoration(VerticalSpaceSize));
        CreateData();
        recycleView.setAdapter(new ItemListAdapter());
    }

    private void CreateData() {
        data.add(new Record("Молоко", 35));
        data.add(new Record("Жизнь", 1));
        data.add(new Record("Курсы", 50));
        data.add(new Record("Хлеб", 26));
        data.add(new Record("Тот самый ужин, который я оплатил за всех, потому что платил картой", 60000));
        data.add(new Record("", 604));
        data.add(new Record("Ракета Falcon Heavy", 1));
        data.add(new Record("Лего тысячилетний сокол", 1000000000));
        data.add(new Record("Монитор", 100));
        data.add(new Record("MacBook Pro", 100));
        data.add(new Record("Шоколадка", 100));
        data.add(new Record("Шкаф", 100));
    }

    private class ItemListAdapter extends RecyclerView.Adapter<RecordViewHolder> {
        @NonNull
        @Override
        public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new RecordViewHolder(LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_record, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecordViewHolder viewHolder, int i) {
            Record record = data.get(i);
            viewHolder.applyData(record);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    private class RecordViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView price;

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void applyData(Record record) {
            title.setText(String.valueOf(record.getTitle()));

            String priceText = String.format((String) getResources().getString(R.string.price_format), record.getPrice());
            price.setText(priceText);
        }
    }

    public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {
        private final int verticalSpaceHeight;

        public VerticalSpaceItemDecoration(int verticalSpaceHeight) {
            this.verticalSpaceHeight = verticalSpaceHeight;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent,
                                   @NonNull RecyclerView.State state) {
            outRect.bottom = verticalSpaceHeight;
        }
    }
}
