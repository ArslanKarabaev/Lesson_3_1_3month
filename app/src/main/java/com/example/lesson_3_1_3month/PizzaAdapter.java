package com.example.lesson_3_1_3month;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaViewHolder> {

    private ArrayList<Uri> images;

    public PizzaAdapter(ArrayList<Uri> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PizzaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pizza, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder, int position) {
        holder.bind(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void setImages(Uri image) {
        images.add(image);
    }
}
