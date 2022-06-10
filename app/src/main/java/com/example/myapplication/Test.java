package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends  AppCompatActivity {

    int Score = 0;
    int remainingQuestions = 5;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();
        String subject = intent.getStringExtra("sub");

        getTest(subject);

        Button next_ques = (Button) findViewById(R.id.button_next);

        next_ques.setOnClickListener(v -> getTest(subject)

        );

    }

        public void getTest(String subject) {

            TextView question = findViewById(R.id.question);
            TextView option1 = findViewById(R.id.answer1);
            TextView option2 = findViewById(R.id.answer2);
            TextView option3 = findViewById(R.id.answer3);
            TextView option4 = findViewById(R.id.answer4);
            TextView remainQ = findViewById(R.id.remainingQuestions);
            Button next_ques = (Button) findViewById(R.id.button_next);

            remainQ.setText(Integer.toString(remainingQuestions));

            option1.setTextColor(Color.WHITE);
            option2.setTextColor(Color.WHITE);
            option3.setTextColor(Color.WHITE);
            option4.setTextColor(Color.WHITE);

            int numberQ = TestInfo.setQuestion();

            if (subject.equals("Maths")) {

                question.setText(TestInfo.List_Questions_Maths[numberQ][0]);
                option1.setText(TestInfo.List_Questions_Maths[numberQ][1]);
                option2.setText(TestInfo.List_Questions_Maths[numberQ][2]);
                option3.setText(TestInfo.List_Questions_Maths[numberQ][3]);
                option4.setText(TestInfo.List_Questions_Maths[numberQ][4]);

                int num = Integer.parseInt(TestInfo.List_Questions_Maths[numberQ][5]);

                check(num);

            }

            if (subject.equals("Internet")) {

                question.setText(TestInfo.List_Questions_Internet[numberQ][0]);
                option1.setText(TestInfo.List_Questions_Internet[numberQ][1]);
                option2.setText(TestInfo.List_Questions_Internet[numberQ][2]);
                option3.setText(TestInfo.List_Questions_Internet[numberQ][3]);
                option4.setText(TestInfo.List_Questions_Internet[numberQ][4]);

                int num = Integer.parseInt(TestInfo.List_Questions_Internet[numberQ][5]);

                check(num);

            }

            if (subject.equals("Computer")) {

                question.setText(TestInfo.List_Questions_Computer[numberQ][0]);
                option1.setText(TestInfo.List_Questions_Computer[numberQ][1]);
                option2.setText(TestInfo.List_Questions_Computer[numberQ][2]);
                option3.setText(TestInfo.List_Questions_Computer[numberQ][3]);
                option4.setText(TestInfo.List_Questions_Computer[numberQ][4]);

                int num = Integer.parseInt(TestInfo.List_Questions_Computer[numberQ][5]);

                check(num);

            }

            if (subject.equals("World")) {

                question.setText(TestInfo.List_Questions_World[numberQ][0]);
                option1.setText(TestInfo.List_Questions_World[numberQ][1]);
                option2.setText(TestInfo.List_Questions_World[numberQ][2]);
                option3.setText(TestInfo.List_Questions_World[numberQ][3]);
                option4.setText(TestInfo.List_Questions_World[numberQ][4]);

                int num = Integer.parseInt(TestInfo.List_Questions_World[numberQ][5]);

                check(num);

            }

            if (subject.equals("Sports")) {

                question.setText(TestInfo.List_Questions_Sports[numberQ][0]);
                option1.setText(TestInfo.List_Questions_Sports[numberQ][1]);
                option2.setText(TestInfo.List_Questions_Sports[numberQ][2]);
                option3.setText(TestInfo.List_Questions_Sports[numberQ][3]);
                option4.setText(TestInfo.List_Questions_Sports[numberQ][4]);

                int num = Integer.parseInt(TestInfo.List_Questions_Sports[numberQ][5]);

                check(num);

            }

            remainingQuestions--;
            if (remainingQuestions == 0) {
                next_ques.setText("Finish");
               // Intent intent = new Intent(Test.this, High.class);
                //int score = Score;
               // intent.putExtra("sub",subject);
               // startActivity(intent);
            }
        }

        public void check(int num) {


            Context context = getApplicationContext();

            TextView option1 = findViewById(R.id.answer1);
            TextView option2 = findViewById(R.id.answer2);
            TextView option3 = findViewById(R.id.answer3);
            TextView option4 = findViewById(R.id.answer4);

            option1.setOnClickListener(v -> {
                try {
                    if (num == 1) {
                        Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT).show();
                        option1.setTextColor(Color.GREEN);
                        Score++;
                    }
                    else {
                        Toast.makeText(context,"Wrong!", Toast.LENGTH_SHORT).show();
                        option1.setTextColor(Color.RED);
                        switch (num) {
                            case 2: option2.setTextColor(Color.GREEN);
                                    break;
                            case 3: option3.setTextColor(Color.GREEN);
                                    break;
                            case 4: option4.setTextColor(Color.GREEN);
                                    break;
                        }

                    }
                } catch (NumberFormatException ex) {
                    // Display message when exception occurs
                    System.out.println("--ERROR--");
                }
                option1.setClickable(false);
                option2.setClickable(false);
                option3.setClickable(false);
                option4.setClickable(false);
            });
            option2.setOnClickListener(v -> {
                try {
                    if (num == 2) {
                        Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT).show();
                        option2.setTextColor(Color.GREEN);
                        Score++;
                    }
                    else {
                        Toast.makeText(context,"Wrong!", Toast.LENGTH_SHORT).show();
                        option2.setTextColor(Color.RED);
                        switch (num) {
                            case 1: option1.setTextColor(Color.GREEN);
                                    break;
                            case 3: option3.setTextColor(Color.GREEN);
                                    break;
                            case 4: option4.setTextColor(Color.GREEN);
                                    break;
                        }
                    }
                } catch (NumberFormatException ex) {
                    // Display message when exception occurs
                    System.out.println("--ERROR--");
                }
                option1.setClickable(false);
                option2.setClickable(false);
                option3.setClickable(false);
                option4.setClickable(false);
            });
            option3.setOnClickListener(v -> {
                try {
                    if (num == 3) {
                        Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT).show();
                        option3.setTextColor(Color.GREEN);
                        Score++;
                    }
                    else {
                        Toast.makeText(context,"Wrong!", Toast.LENGTH_SHORT).show();
                        option3.setTextColor(Color.RED);
                        switch (num) {
                            case 1: option1.setTextColor(Color.GREEN);
                                    break;
                            case 2: option2.setTextColor(Color.GREEN);
                                    break;
                            case 4: option4.setTextColor(Color.GREEN);
                                    break;
                        }
                    }
                } catch (NumberFormatException ex) {
                    // Display message when exception occurs
                    System.out.println("--ERROR--");
                }
                option1.setClickable(false);
                option2.setClickable(false);
                option3.setClickable(false);
                option4.setClickable(false);
            });
            option4.setOnClickListener(v -> {
                try {
                    if (num == 4) {
                        Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT).show();
                        option4.setTextColor(Color.GREEN);
                        Score++;
                    }
                    else {
                        Toast.makeText(context,"Wrong!", Toast.LENGTH_SHORT).show();
                        option4.setTextColor(Color.RED);
                        switch (num) {
                            case 1: option1.setTextColor(Color.GREEN);
                                    break;
                            case 2: option2.setTextColor(Color.GREEN);
                                    break;
                            case 3: option3.setTextColor(Color.GREEN);
                                    break;
                        }
                        option1.setClickable(false);
                        option2.setClickable(false);
                        option3.setClickable(false);
                        option4.setClickable(false);
                    }
                } catch (NumberFormatException ex) {
                    // Display message when exception occurs
                    System.out.println("--ERROR--");
                }
            });

        }

    }
