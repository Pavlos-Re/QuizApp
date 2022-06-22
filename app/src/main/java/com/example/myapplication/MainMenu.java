package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;

public class MainMenu extends AppCompatActivity {
    private static final Random RANDOM = new Random(); //this will be used for the random fun fact
    private static Context context; //creating context to get the string from the xml file
    Button button2;
    MediaPlayer media;
    MediaPlayer media2;
    int counter = 0;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        media2 = MediaPlayer.create(this, R.raw.pop);
        media = MediaPlayer.create(this, R.raw.street_soul);
        setContentView(R.layout.activity_main_menu);
        TextView fun = (TextView)findViewById(R.id.textView);
        Button button_fact = (Button) findViewById(R.id.fact_button);
        //the function that prints the fun fact in the textview will be called when the button is clicked
        button_fact.setOnClickListener(v -> {
            counter++;
            media2.start();
            if(counter==1)
                getFact();
            else {
                fun.setText(" ");
                counter=0;
                image = findViewById(R.id.smart_pic);
                image.setVisibility(View.INVISIBLE);
            }

        });
        Button button_subject = (Button) findViewById(R.id.choose_subject_button);
        button_subject.setOnClickListener(v -> {
            media2.start();
            Intent intent = new Intent(MainMenu.this, SubjectList.class);
            startActivity(intent);
        });
        Button button_high_score = (Button) findViewById(R.id.check_highscores_button);
        button_high_score.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainMenu.this, HighScores.class);
            media2.start();
            startActivity(intent2);
        });

        }
        //adding functionality for the back-button of
    @Override
    public void onBackPressed() {

        button2 = findViewById(R.id.button_sound_on_off);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Go back to start menu?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainMenu.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    public static Context getContext(){
        return context;
    }
    public void getFact(){
        TextView fun = (TextView)findViewById(R.id.textView);
        //creating an array of the fun facts that are located in "strings.xml"
        final String[] FACTS = {
                context.getResources().getString(R.string.fact1),
                context.getResources().getString(R.string.fact2),
                context.getResources().getString(R.string.fact3),
                context.getResources().getString(R.string.fact4),
                context.getResources().getString(R.string.fact5),
                context.getResources().getString(R.string.fact6),
                context.getResources().getString(R.string.fact7),
                context.getResources().getString(R.string.fact8),
                context.getResources().getString(R.string.fact9),
                context.getResources().getString(R.string.fact10),
        };
        //Getting a random fact from the array. A number between 0 and 9 will be chosen and then
        //the string that corresponds to that number will appear in the text view.
        int fun_fact = RANDOM.nextInt(FACTS.length);
        fun.setText(FACTS[fun_fact]);
        image = findViewById(R.id.smart_pic);
        image.setVisibility(View.VISIBLE);
    }

}




