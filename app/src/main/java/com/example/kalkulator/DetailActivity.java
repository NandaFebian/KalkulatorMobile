package com.example.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView tvResult;
    private StringBuilder currentNumber;
    private double firstNumber;
    private double secondNumber;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvResult = findViewById(R.id.tvResult);
        currentNumber = new StringBuilder();

        // Set OnClickListener for number buttons
        findViewById(R.id.btn1).setOnClickListener(v -> appendNumber("1"));
        findViewById(R.id.btn2).setOnClickListener(v -> appendNumber("2"));
        findViewById(R.id.btn3).setOnClickListener(v -> appendNumber("3"));
        findViewById(R.id.btn4).setOnClickListener(v -> appendNumber("4"));
        findViewById(R.id.btn5).setOnClickListener(v -> appendNumber("5"));
        findViewById(R.id.btn6).setOnClickListener(v -> appendNumber("6"));
        findViewById(R.id.btn7).setOnClickListener(v -> appendNumber("7"));
        findViewById(R.id.btn8).setOnClickListener(v -> appendNumber("8"));
        findViewById(R.id.btn9).setOnClickListener(v -> appendNumber("9"));
        findViewById(R.id.btn0).setOnClickListener(v -> appendNumber("0"));

        // Set OnClickListener for operator buttons
        findViewById(R.id.btnPlus).setOnClickListener(v -> setOperator("+"));
        findViewById(R.id.btnMinus).setOnClickListener(v -> setOperator("-"));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> setOperator("*"));
        findViewById(R.id.btnDivide).setOnClickListener(v -> setOperator("/"));

        // Set OnClickListener for equals button
        findViewById(R.id.btnEquals).setOnClickListener(v -> calculateResult());

        // Set OnClickListener for button to return to main menu
        Button btnMenuUtama = findViewById(R.id.btnMenuUtama);
        btnMenuUtama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMainMenu();
            }
        });

        // Set OnClickListener for button to navigate to HasilActivity
        Button btnHasil = findViewById(R.id.btnHasil);
        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Memperoleh hasil perhitungan
                String resultText = tvResult.getText().toString();
                // Memperoleh operasi yang dilakukan
                String operation = firstNumber + " " + operator + " " + secondNumber;
                // Membuat riwayat perhitungan
                String history = operation + " = " + resultText;
                // Tambahkan riwayat perhitungan ke DataManager
                DataManager.addHistoryData(DetailActivity.this, history);

                openHasilActivity();
            }
        });
    }

    private void appendNumber(String number) {
        currentNumber.append(number);
        updateDisplay();
    }

    private void setOperator(String op) {
        operator = op;
        firstNumber = Double.parseDouble(currentNumber.toString());
        currentNumber.setLength(0);
    }

    private void calculateResult() {
        secondNumber = Double.parseDouble(currentNumber.toString());
        double result = 0;
        if (operator.equals("+")) {
            result = firstNumber + secondNumber;
        } else if (operator.equals("-")) {
            result = firstNumber - secondNumber;
        } else if (operator.equals("*")) {
            result = firstNumber * secondNumber;
        } else if (operator.equals("/")) {
            if (secondNumber != 0) {
                result = firstNumber / secondNumber;
            } else {
                // Handle division by zero error
            }
        }

        tvResult.setText(String.valueOf(result));
    }

    private void updateDisplay() {
        tvResult.setText(currentNumber.toString());
    }

    // Method to return to main menu
    public void backToMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    // Method to navigate to HasilActivity
    private void openHasilActivity() {
        Intent intent = new Intent(this, HasilActivity.class);
        startActivity(intent);
    }
}
