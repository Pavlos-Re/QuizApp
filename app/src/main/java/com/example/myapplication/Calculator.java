package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    EditText e1, e2;
    TextView t1;
    int num1, num2;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        final MediaPlayer media2 = MediaPlayer.create(Calculator.this, R.raw.pop );
        back = (Button) findViewById(R.id.button_back);
        back.setOnClickListener(v -> {
            media2.start();
            Intent intent = new Intent(Calculator.this, MainActivity.class);
            startActivity(intent);
        });
    }

    // a public method to get the input numbers
    public boolean getNumbers() {

        // defining the edit text 1 to e1
        e1 = (EditText) findViewById(R.id.num1);

        // defining the edit text 2 to e2
        e2 = (EditText) findViewById(R.id.num2);

        // defining the text view to t1
        t1 = (TextView) findViewById(R.id.result);

        // taking input from text box 1
        String s1 = e1.getText().toString();

        // taking input from text box 2
        String s2 = e2.getText().toString();

        // condition to check if box is not empty
        if ((s1.equals("") || s2.equals(""))) {

            String result = "Please enter both values";
            t1.setText(result);

            return false;
        }

        else {
            // converting string to int.
            num1 = Integer.parseInt(s1);

            // converting string to int.
            num2 = Integer.parseInt(s2);
        }

        return true;
    }

    // a public method to perform addition
    public void doSum(View v) {

        // get the input numbers
        if (getNumbers()) {
            int sum = num1 + num2;
            t1.setText(Integer.toString(sum));
        }
    }


    // a public method to perform subtraction
    public void doSub(View v) {

        // get the input numbers
        if (getNumbers()) {
            int sum = num1 - num2;
            t1.setText(Integer.toString(sum));
        }
    }

    // a public method to perform multiplication
    public void doMul(View v) {

        // get the input numbers
        if (getNumbers()) {
            int sum = num1 * num2;
            t1.setText(Integer.toString(sum));
        }
    }

    // a public method to perform Division
    public void doDiv(View v) {

        // get the input numbers
        if (getNumbers()) {

            // displaying the text in text view assigned as t1
            double sum = num1 / (num2 * 1.0);
            t1.setText(Double.toString(sum));
        }
    }


}