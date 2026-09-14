package com.example.genderregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nameEdit, emailEdit;
    RadioGroup genderGroup;
    RadioButton mRadio, fradio;
    Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdit = findViewById(R.id.nameEdit);
        emailEdit = findViewById(R.id.emailEdit);
        genderGroup = findViewById(R.id.genderGroup);
        mRadio = findViewById(R.id.maleRadio);
        fradio = findViewById(R.id.femaleRadio);
        regBtn = findViewById(R.id.regBtn);

        regBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = nameEdit.getText().toString().trim();
        String email = emailEdit.getText().toString().trim();
        if (name.isEmpty() || email.isEmpty()){
            Toast.makeText(
                    MainActivity.this,
                    "Please enter all details!",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }
        int selectedGender = genderGroup.getCheckedRadioButtonId();
        if (selectedGender == -1) {
            Toast.makeText(
                    MainActivity.this,
                    "Please select gender",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }
        if (selectedGender == mRadio.getId()) {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            MaleActivity.class
                    );
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("gender", "Male");

            startActivity(intent);
        }
        else if (selectedGender == fradio.getId()) {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            FemaleActivity.class
                    );
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("gender", "Female");
            startActivity(intent);
        }
    }
}