package com.example.genderregistration;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FemaleActivity extends AppCompatActivity {

    TextView femaleName, femaleEmail, femaleGender;

    Button femaleBackBtn, femaleSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female);

        femaleName = findViewById(R.id.femaleName);
        femaleEmail = findViewById(R.id.femaleEmail);
        femaleGender = findViewById(R.id.femaleGender);

        femaleBackBtn = findViewById(R.id.femaleBackBtn);
        femaleSubmitBtn = findViewById(R.id.femaleSubmitBtn);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String gender = getIntent().getStringExtra("gender");

        femaleName.setText("Name : " + name);
        femaleEmail.setText("Email : " + email);
        femaleGender.setText("Gender : " + gender);

        femaleBackBtn.setOnClickListener(view -> {
            finish();
        });
        femaleSubmitBtn.setOnClickListener(view -> {
            Toast.makeText(
                    FemaleActivity.this,
                    "Registration Submitted",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}