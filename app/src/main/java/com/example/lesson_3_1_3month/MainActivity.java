package com.example.lesson_3_1_3month;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_pizza;
    private ArrayList<Uri> images = new ArrayList<>();
    private final int pizzaCode = 283;
    private Button btnOpenGallery;
    private PizzaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        clickListener();

    }

    private void clickListener() {
    btnOpenGallery.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, pizzaCode);
        }
    });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == pizzaCode && resultCode == RESULT_OK && data != null){
            Uri imageResult = data.getData();
            adapter = new PizzaAdapter(images);
            adapter.setImages(imageResult);
            rv_pizza.setAdapter(adapter);
        }
    }

    private void initView() {
        rv_pizza = findViewById(R.id.rv_pizza);
        btnOpenGallery = findViewById(R.id.btn_openGallery);
    }
}