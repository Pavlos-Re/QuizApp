package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends  AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();
        String subject = intent.getStringExtra("sub");

        if (subject.equals("Maths")) {
            getTest();
        }

    }
        public void getTest() {

            TextView question = findViewById(R.id.question);
            TextView option1 = findViewById(R.id.option1);
            TextView option2 = findViewById(R.id.option2);
            TextView option3 = findViewById(R.id.option3);
            TextView option4 = findViewById(R.id.option4);

            int numberQ = TestInfo.setQuestion();

            question.setText(TestInfo.List_Questions_Maths[numberQ][0]);
            option1.setText(TestInfo.List_Questions_Maths[numberQ][1]);
            option2.setText(TestInfo.List_Questions_Maths[numberQ][2]);
            option3.setText(TestInfo.List_Questions_Maths[numberQ][3]);
            option4.setText(TestInfo.List_Questions_Maths[numberQ][4]);

            check(numberQ);

        }

        public void check(int numberQ) {

            Context context = getApplicationContext();

            TextView option1 = findViewById(R.id.option1);
            TextView option2 = findViewById(R.id.option2);
            TextView option3 = findViewById(R.id.option3);
            TextView option4 = findViewById(R.id.option4);

            option1.setOnClickListener(v -> {
                try {
                    if (Integer.parseInt(TestInfo.List_Questions_Maths[numberQ][5]) == 1) {
                        Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(context,"Wrong!", Toast.LENGTH_SHORT).show();
                    }
                    getTest();
                } catch (NumberFormatException ex) {
                    // Display message when exception occurs
                    System.out.println("--ERROR--");
                }
            });
            option2.setOnClickListener(v -> {
                try {
                    if (Integer.parseInt(TestInfo.List_Questions_Maths[numberQ][5]) == 2) {
                        Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(context,"Wrong!", Toast.LENGTH_SHORT).show();
                    }
                    getTest();
                } catch (NumberFormatException ex) {
                    // Display message when exception occurs
                    System.out.println("--ERROR--");
                }
            });
            option3.setOnClickListener(v -> {
                try {
                    if (Integer.parseInt(TestInfo.List_Questions_Maths[numberQ][5]) == 3) {
                        Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(context,"Wrong!", Toast.LENGTH_SHORT).show();
                    }
                    getTest();
                } catch (NumberFormatException ex) {
                    // Display message when exception occurs
                    System.out.println("--ERROR--");
                }
            });
            option4.setOnClickListener(v -> {
                try {
                    if (Integer.parseInt(TestInfo.List_Questions_Maths[numberQ][5]) == 4) {
                        Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(context,"Wrong!", Toast.LENGTH_SHORT).show();
                    }
                    getTest();
                } catch (NumberFormatException ex) {
                    // Display message when exception occurs
                    System.out.println("--ERROR--");
                }
            });

        }

    }
