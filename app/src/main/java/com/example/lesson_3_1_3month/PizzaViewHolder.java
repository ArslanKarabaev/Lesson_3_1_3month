package com.example.lesson_3_1_3month;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PizzaViewHolder extends RecyclerView.ViewHolder {
    private ImageView iv_pizza;

    public PizzaViewHolder(@NonNull View itemView) {
        super(itemView);
        iv_pizza = itemView.findViewById(R.id.iv_pizza);
    }

    public void bind(Uri image){
        iv_pizza.setImageURI(image);
    }
}
