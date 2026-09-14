package com.example.genderregistration;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MaleActivity extends AppCompatActivity
        implements View.OnClickListener {

    TextView maleName, maleEmail, maleGender;

    Button maleBackBtn, maleSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male);

        // Connect XML components

        maleName = findViewById(R.id.maleName);
        maleEmail = findViewById(R.id.maleEmail);
        maleGender = findViewById(R.id.maleGender);

        maleBackBtn = findViewById(R.id.maleBackBtn);
        maleSubmitBtn = findViewById(R.id.maleSubmitBtn);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String gender = getIntent().getStringExtra("gender");

        maleName.setText("Name : " + name);
        maleEmail.setText("Email : " + email);
        maleGender.setText("Gender : " + gender);

        maleBackBtn.setOnClickListener(this);
        maleSubmitBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.maleBackBtn) {
            finish();
        }
        if (view.getId() == R.id.maleSubmitBtn) {
            Toast.makeText(
                    MaleActivity.this,
                    "Registration Submitted",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}