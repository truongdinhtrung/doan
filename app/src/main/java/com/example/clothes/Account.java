package com.example.clothes;

import static com.example.clothes.R.id.bottom_account;
import static com.example.clothes.R.id.bottom_home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Account extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
TextView txtLogout, textView;
ImageView btnlogout1;
    FirebaseAuth mAuth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        mAuth=FirebaseAuth.getInstance();
        if(user==null){
                Intent intent= new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();

        }
        else {
            textView.setText(user.getEmail());
        }
      btnlogout1.setOnClickListener(v -> {
              FirebaseAuth.getInstance().signOut();
              Intent intent= new Intent(getApplicationContext(), Login.class);
              startActivity(intent);
              finish();
      });
        bottomNavigationView = findViewById(R.id.bottomnavagation);
        bottomNavigationView.setSelectedItemId(bottom_account);

        bottomNavigationView.setOnItemSelectedListener(item -> {
           if (item.getItemId() == bottom_account) {
                return true;
            }
            else if (item.getItemId() == bottom_home)
            {
                startActivity(new Intent(getApplicationContext(), HomePage.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            else if (item.getItemId() == R.id.bottom_heart) {
                startActivity(new Intent(getApplicationContext(), heart.class));
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
        addControl();
        txtLogout.setOnClickListener(v -> {
            Intent intent= new Intent(Account.this,Login.class );
            startActivity(intent);
        });
    }

    private void addControl() {
        txtLogout= findViewById(R.id.txtLogout);
       textView=findViewById(R.id.txtname);
        btnlogout1=findViewById(R.id.btnlogout1);
        user= mAuth.getCurrentUser();
    }
}