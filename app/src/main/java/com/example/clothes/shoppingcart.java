package com.example.clothes;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;



public class shoppingcart extends AppCompatActivity {
ImageButton imgbtnback3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);
        addcontrol();
        imgbtnback3.setOnClickListener(v -> {
            Intent intent= new Intent(shoppingcart.this, HomePage.class);
            startActivity(intent);
        });

    }

    private void addcontrol() {

        imgbtnback3=findViewById(R.id.imgbtnback3);
    }
}