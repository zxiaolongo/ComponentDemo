package com.zxl.coordinatorlayoutdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MAdapter extends RecyclerView.Adapter<MAdapter.MViewHolder> {
    private List<String> list;
    public MAdapter(List<String> list){
        this.list = list;
    }
    @NonNull
    @Override
    public MAdapter.MViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_text, viewGroup, false);
        return new MViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MAdapter.MViewHolder viewHolder, int i) {
        viewHolder.textView.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    static class MViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }
}
