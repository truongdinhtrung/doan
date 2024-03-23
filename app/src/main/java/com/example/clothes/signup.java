package com.example.clothes;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    EditText edtFullname, edtEmail2, edtPassword2, edtRepeatPassword;
    Button btnSignup;
    TextView txtLogin;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent= new Intent(getApplicationContext(), HomePage.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        mAuth = FirebaseAuth.getInstance();
        addControl();
        btnSignup.setOnClickListener(v -> {
            String Fullname = edtFullname.getText().toString().trim();
            String email = edtEmail2.getText().toString().trim();
            String password = edtPassword2.getText().toString().trim();
            String RepeatPassword = edtRepeatPassword.getText().toString().trim();
         /*   Intent intent = new Intent(signup.this, Login.class);
            intent.putExtra("Fullname", Fullname);
            intent.putExtra("Email", email);
            intent.putExtra("Password", password);
            intent.putExtra("RepeatPassword", RepeatPassword);*/

            if (Fullname.isEmpty()) {
                Toast.makeText(signup.this, "Enter FullName", Toast.LENGTH_SHORT).show();
                return;
            }
            if (email.isEmpty()) {
                Toast.makeText(signup.this, "Enter Email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.isEmpty()) {
                Toast.makeText(signup.this, "Enter Password", Toast.LENGTH_SHORT).show();
                return;
            }
            if (RepeatPassword.isEmpty()) {
                Toast.makeText(signup.this, "Enter RepeatPassword", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword( email, password)
                    .addOnCompleteListener(task -> {

                        if (task.isSuccessful()) {
                            Toast.makeText(signup.this, "Account created.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(getApplicationContext(), HomePage.class);
                            startActivity(intent1);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(signup.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

        });
        txtLogin.setOnClickListener(v1 -> {
            Intent intent12 = new Intent(signup.this, Login.class);
            startActivity(intent12);
        });
    }

    private void addControl() {
        edtFullname=findViewById(R.id.edtFullname);
        edtEmail2=findViewById(R.id.edtEmail2);
        edtPassword2=findViewById(R.id.edtPassword2);
        edtRepeatPassword=findViewById(R.id.edtRepeatPassword);
        btnSignup=findViewById(R.id.btnSignUp);
        txtLogin=findViewById(R.id.txtLogin);
    }
}