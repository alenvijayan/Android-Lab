package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView display;
    Button btn0, btn1 ,btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnAdd, btnSub, btnMul, btnDiv;
    Button btnEq, btnDot;
    double firstNumber = 0;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        btnEq = findViewById(R.id.btnEqual);
        btnDot = findViewById(R.id.btnDot);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        btnEq.setOnClickListener(this);
        btnDot.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        // Numbers

        if (id == R.id.btn0) {
            addNumber("0");
        }
        else if (id == R.id.btn1) {
            addNumber("1");
        }
        else if (id == R.id.btn2) {
            addNumber("2");
        }
        else if (id == R.id.btn3) {
            addNumber("3");
        }
        else if (id == R.id.btn4) {
            addNumber("4");
        }
        else if (id == R.id.btn5) {
            addNumber("5");
        }
        else if (id == R.id.btn6) {
            addNumber("6");
        }
        else if (id == R.id.btn7) {
            addNumber("7");
        }
        else if (id == R.id.btn8) {
            addNumber("8");
        }
        else if (id == R.id.btn9) {
            addNumber("9");
        }

        // Decimal

        else if (id == R.id.btnDot) {

            if (!display.getText().toString().contains(".")) {
                display.append(".");
            }
        }

        // Operators

        else if (id == R.id.btnAdd) {
            setOperator("+");
        }

        else if (id == R.id.btnSub) {
            setOperator("-");
        }

        else if (id == R.id.btnMul) {
            setOperator("*");
        }

        else if (id == R.id.btnDiv) {
            setOperator("/");
        }

        // Equal

        else if (id == R.id.btnEqual) {
            calculate();
        }
    }

    private void addNumber(String number) {

        if (display.getText().toString().equals("0")) {
            display.setText(number);
        }
        else {
            display.append(number);
        }
    }

    private void setOperator(String op) {

        firstNumber = Double.parseDouble(
                display.getText().toString()
        );

        operator = op;

        display.setText("0");
    }

    private void calculate() {

        double secondNumber = Double.parseDouble(
                display.getText().toString()
        );

        double answer = 0;

        if (operator.equals("+")) {
            answer = firstNumber + secondNumber;
        }

        else if (operator.equals("-")) {
            answer = firstNumber - secondNumber;
        }

        else if (operator.equals("*")) {
            answer = firstNumber * secondNumber;
        }

        else if (operator.equals("/")) {

            if (secondNumber == 0) {
                display.setText("Error");
                return;
            }

            answer = firstNumber / secondNumber;
        }

        display.setText(String.valueOf(answer));

        operator = "";
    }

}