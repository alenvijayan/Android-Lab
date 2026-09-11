package com.example.factorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button check;
    EditText num;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        check = findViewById(R.id.btnFact);
        num = findViewById(R.id.num);
        res = findViewById(R.id.txtResult);

        check.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String input = num.getText().toString();
        if(input.isEmpty()){
            res.setText("Enter a number");
            return;
        }
        int n = Integer.parseInt(input);
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        res.setText("Factorial = " + fact);
    }
}
