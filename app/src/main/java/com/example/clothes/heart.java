package com.example.clothes;

import static com.example.clothes.R.id.bottom_account;
import static com.example.clothes.R.id.bottom_heart;
import static com.example.clothes.R.id.bottom_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class heart extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);
        bottomNavigationView = findViewById(R.id.bottomnavagation);
        bottomNavigationView.setSelectedItemId(bottom_heart);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId()==bottom_heart)
                return true;
            else if(item.getItemId()== bottom_home){
                startActivity(new Intent(getApplicationContext(), HomePage.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            else if (item.getItemId() == bottom_account)
            {
                startActivity(new Intent(getApplicationContext(), Account.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }

            else if (item.getItemId() == R.id.bottom_shoppingcart) {
                startActivity(new Intent(getApplicationContext(), shoppingcart.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }

            return false;
        });
    }
}