package com.example.myapplication;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test extends  AppCompatActivity {

    int Score = 0;
    int remainingQuestions = 5;

    int highScore1;
    int highScore2;
    int highScore3;
    int highScore4;
    int highScore5;

    TextView Math;
    TextView Computer;
    TextView Internet;
    TextView World;
    TextView Sports;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    int check;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();
        String subject = intent.getStringExtra("sub");

        getTest(subject);

        Math = findViewById(R.id.Maths);
        Computer = findViewById(R.id.Computer);
        Internet = findViewById(R.id.Internet);
        World = findViewById(R.id.World);
        Sports = findViewById(R.id.Sports);

        prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        editor = getSharedPreferences("myPrefsKey", MODE_PRIVATE).edit();
        highScore1 = prefs.getInt("score",0);
        highScore2 = prefs.getInt("score2",0);
        highScore3 = prefs.getInt("score3",0);
        highScore4 = prefs.getInt("score4",0);
        highScore5 = prefs.getInt("score5",0);


        Button next_ques = findViewById(R.id.button_next);
        next_ques.setOnClickListener(v -> getTest(subject)

        );

        //next_ques.setClickable(false);

}

        public void getTest(String subject) {

            TextView question = findViewById(R.id.question);
            TextView option1 = findViewById(R.id.answer1);
            TextView option2 = findViewById(R.id.answer2);
            TextView option3 = findViewById(R.id.answer3);
            TextView option4 = findViewById(R.id.answer4);
            TextView remainQ = findViewById(R.id.remainingQuestions);
            Button next_ques = findViewById(R.id.button_next);

            remainQ.setText(Integer.toString(remainingQuestions));

            option1.setTextColor(Color.WHITE);
            option2.setTextColor(Color.WHITE);
            option3.setTextColor(Color.WHITE);
            option4.setTextColor(Color.WHITE);

            int numberQ = TestInfo.setQuestion();

            if (subject.equals("Maths")) {

                Button button_cal = findViewById(R.id.button_cal);

                button_cal.setOnClickListener(v -> {

                    ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();

                    final PackageManager pm = getPackageManager();
                    List<PackageInfo> packs = pm.getInstalledPackages(0);
                    for (PackageInfo pi : packs) {
                        if( pi.packageName.toString().toLowerCase().contains("calcul")){
                            HashMap<String, Object> map = new HashMap<String, Object>();
                            map.put("appName", pi.applicationInfo.loadLabel(pm));
                            map.put("packageName", pi.packageName);
                            items.add(map);
                        }
                    }

                    if(items.size()>=1){
                        String packageName = (String) items.get(0).get("packageName");
                        Intent i = pm.getLaunchIntentForPackage(packageName);
                        if (i != null)
                            startActivity(i);
                    }
                    else{
                        Toast.makeText(this,"No calculator app found, sorry!",Toast.LENGTH_SHORT).show();
                    }


                });

                question.setText(TestInfo.List_Questions_Maths[numberQ][0]);
                option1.setText(TestInfo.List_Questions_Maths[numberQ][1]);
                option2.setText(TestInfo.List_Questions_Maths[numberQ][2]);
                option3.setText(TestInfo.List_Questions_Maths[numberQ][3]);
                option4.setText(TestInfo.List_Questions_Maths[numberQ][4]);

                int num = Integer.parseInt(TestInfo.List_Questions_Maths[numberQ][5]);

                check(num);



            }

            if (subject.equals("Internet")) {

                Button button_cal = findViewById(R.id.button_cal);

                button_cal.setVisibility(Button.INVISIBLE);

                option1.setTextSize(17);
                option2.setTextSize(17);
                option3.setTextSize(17);
                option4.setTextSize(17);


                question.setText(TestInfo.List_Questions_Internet[numberQ][0]);
                option1.setText(TestInfo.List_Questions_Internet[numberQ][1]);
                option2.setText(TestInfo.List_Questions_Internet[numberQ][2]);
                option3.setText(TestInfo.List_Questions_Internet[numberQ][3]);
                option4.setText(TestInfo.List_Questions_Internet[numberQ][4]);

                option1.setTextSize(20);
                option2.setTextSize(20);
                option3.setTextSize(20);
                option4.setTextSize(20);

                int num = Integer.parseInt(TestInfo.List_Questions_Internet[numberQ][5]);

                check(num);


            }

            if (subject.equals("Computer")) {

                Button button_cal = findViewById(R.id.button_cal);

                button_cal.setVisibility(Button.INVISIBLE);

                question.setText(TestInfo.List_Questions_Computer[numberQ][0]);
                option1.setText(TestInfo.List_Questions_Computer[numberQ][1]);
                option2.setText(TestInfo.List_Questions_Computer[numberQ][2]);
                option3.setText(TestInfo.List_Questions_Computer[numberQ][3]);
                option4.setText(TestInfo.List_Questions_Computer[numberQ][4]);

                int num = Integer.parseInt(TestInfo.List_Questions_Computer[numberQ][5]);

                check(num);



            }

            if (subject.equals("World")) {

                Button button_cal = findViewById(R.id.button_cal);

                button_cal.setVisibility(Button.INVISIBLE);

                question.setText(TestInfo.List_Questions_World[numberQ][0]);
                option1.setText(TestInfo.List_Questions_World[numberQ][1]);
                option2.setText(TestInfo.List_Questions_World[numberQ][2]);
                option3.setText(TestInfo.List_Questions_World[numberQ][3]);
                option4.setText(TestInfo.List_Questions_World[numberQ][4]);

                int num = Integer.parseInt(TestInfo.List_Questions_World[numberQ][5]);

                check(num);


            }

            if (subject.equals("Sports")) {

                Button button_cal = findViewById(R.id.button_cal);

                button_cal.setVisibility(Button.INVISIBLE);

                question.setText(TestInfo.List_Questions_Sports[numberQ][0]);
                option1.setText(TestInfo.List_Questions_Sports[numberQ][1]);
                option2.setText(TestInfo.List_Questions_Sports[numberQ][2]);
                option3.setText(TestInfo.List_Questions_Sports[numberQ][3]);
                option4.setText(TestInfo.List_Questions_Sports[numberQ][4]);

                int num = Integer.parseInt(TestInfo.List_Questions_Sports[numberQ][5]);

                check(num);



            }

            remainingQuestions--;

            if (remainingQuestions < 0) {

                next_ques.setClickable(false);

                question.setText(" ");
                option1.setText(" ");
                option2.setText(" ");
                option3.setText(" ");
                option4.setText(" ");

                next_ques.setText("Finish");

                showScore(subject);
            }
        }

        public void check(int num) {

            Context context = getApplicationContext();

            TextView option1 = findViewById(R.id.answer1);
            TextView option2 = findViewById(R.id.answer2);
            TextView option3 = findViewById(R.id.answer3);
            TextView option4 = findViewById(R.id.answer4);
            Button next_ques = findViewById(R.id.button_next);


            option1.setOnClickListener(v -> {
                try {
                    if (num == 1) {
                        option1.setTextColor(Color.GREEN);
                        Score++;
                    }
                    else {
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
                        option2.setTextColor(Color.GREEN);
                        Score++;
                    }
                    else {
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
                        option3.setTextColor(Color.GREEN);
                        Score++;
                    }
                    else {
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
                        option4.setTextColor(Color.GREEN);
                        Score++;
                    }
                    else {
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

            next_ques.setClickable(true);
        }

    private void showScore(String subject) {

        AlertDialog.Builder dialog2 = new AlertDialog.Builder(this);
        final EditText edittext = new EditText(this);
        dialog2.setCancelable(false);
        dialog2.setView(edittext);
        dialog2.setMessage(getString(R.string.info1) + "\n" + getString(R.string.info2) + "\n");
        dialog2.setTitle(getString(R.string.info0));
        dialog2.setPositiveButton(getString(R.string.affirmative),
                (dialog, which) -> {
                    String  link = null;
                    Editable TextValue = edittext.getText();
                    if (subject.equals("Computer")) {
                        link = "https://en.wikipedia.org/wiki/Computer";
                    }
                    if (subject.equals("World")) {
                        link = "https://en.wikipedia.org/wiki/World";
                    }
                    if (subject.equals("Maths")) {
                        link = "https://en.wikipedia.org/wiki/Mathematics";
                    }
                    if (subject.equals("Sports")) {
                        link = "https://en.wikipedia.org/wiki/Sport";
                    }
                    if (subject.equals("Internet")) {
                        link = "https://en.wikipedia.org/wiki/Internet";
                    }

                    String fromEmail = "quizappmp@gmail.com";
                    String fromPassword = "nfyhiavimindxgmr";
                    String toEmails = TextValue.toString();
                    List toEmailList = Arrays.asList(toEmails
                            .split("\\s*,\\s*"));

                    String emailSubject = "Your Test results from QuizApp";
                    String emailBody = "Greetings! \n" + "Your test results are: " + Score + ".\n You may find this links useful, take care! \n" + link;
                    new SendMailTask(Test.this).execute(fromEmail,
                            fromPassword, toEmailList, emailSubject, emailBody);
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                });
        dialog2.setNegativeButton(R.string.negative,
                (dialog,which) -> {
                    finish();
                });
        AlertDialog alertDialog2 = dialog2.create();

        AlertDialog.Builder dialog1=new AlertDialog.Builder(this);
        dialog1.setCancelable(false);
        dialog1.setMessage(getString(R.string.score) + Score);
        dialog1.setTitle(R.string.congratulations);
        dialog1.setPositiveButton("OK!",
                (dialog, which) -> {
                    //finish();

                    if(subject.equals("Maths")) {
                        if (highScore1 > Score) {

                        } else {
                            highScore1 = Score;
                            editor.putInt("score", highScore1);
                            editor.commit();
                        }

                    }
                    else if(subject.equals("World")) {
                        if (highScore2 > Score) {

                        } else {
                            highScore2 = Score;
                            editor.putInt("score2", highScore2);
                            editor.commit();
                        }

                    }
                    else if(subject.equals("Sports")) {
                        if (highScore3> Score) {

                        } else {
                            highScore3 = Score;
                            editor.putInt("score3", highScore3);
                            editor.commit();
                        }

                    }
                    else if(subject.equals("Internet")) {
                        if (highScore4 > Score) {

                        } else {
                            highScore4 = Score;
                            editor.putInt("score4", highScore4);
                            editor.commit();
                        }

                    }
                    else if(subject.equals("Computer")) {
                        if (highScore5 > Score) {

                        } else {
                            highScore5 = Score;
                            editor.putInt("score5", highScore5);
                            editor.commit();
                        }

                    }

                    alertDialog2.show();
                });
        AlertDialog alertDialog1=dialog1.create();
        alertDialog1.show();

    }

    }
