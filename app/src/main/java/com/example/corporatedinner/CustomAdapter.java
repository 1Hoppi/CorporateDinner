package com.example.corporatedinner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    String[] localData;

    public CustomAdapter(String[] dataSet) {
        localData = dataSet;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        holder.getTextDescription().setText(localData[position]);
    }

    @Override
    public int getItemCount() {
        return localData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textDescription = itemView.findViewById(R.id.textView);
        }

        public TextView getTextDescription(){
            return textDescription;
        }
    }
}
