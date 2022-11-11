package com.example.ejercicioadicionalrepasoexamen.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PartidoAdapter extends RecyclerView.Adapter<PartidoAdapter.PartidoVH> {

    @NonNull
    @Override
    public PartidoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PartidoVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PartidoVH extends RecyclerView.ViewHolder {
        public PartidoVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
