package com.example.tutorialspoint7.myapplication.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tutorialspoint7.myapplication.Model.MyModel;
import com.example.tutorialspoint7.myapplication.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private ArrayList<MyModel> list;
    private static ClickListener clickListener;

    public static void setOnItemClickListener(View.OnClickListener onClickListener) {
        MainAdapter.clickListener = clickListener;
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        MainAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public MainAdapter(ArrayList<MyModel> list){
        this.list = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        ImageView imageVIew;
        View bg;
        MyViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            this.textView = v.findViewById(R.id.cardTitle);
            this.imageVIew = v.findViewById(R.id.imageView);
            this.bg = v.findViewById(R.id.view);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(),v);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_recycler_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView textview = holder.textView;
        ImageView iv = holder.imageVIew;
        View bg = holder.bg;
        textview.setText(list.get(position).getTitle());
        iv.setImageResource(list.get(position).getImageUil());
        bg.setBackgroundResource(list.get(position).getBg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
