package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HighScores extends AppCompatActivity {
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);
        TextView Maths = (TextView)findViewById(R.id.Maths);
        TextView World = (TextView)findViewById(R.id.World);
        TextView Sports = (TextView)findViewById(R.id.Sports);
        TextView Internet = (TextView)findViewById(R.id.Internet);
        TextView Computer = (TextView)findViewById(R.id.Computer);

        prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int string = prefs.getInt("score",0);
        int string2 = prefs.getInt("score2",0);
        int string3 = prefs.getInt("score3",0);
        int string4 = prefs.getInt("score4",0);
        int string5 = prefs.getInt("score5",0);

        Maths.setText(String.valueOf(string));
        World.setText(String.valueOf(string2));
        Sports.setText(String.valueOf(string3));
        Internet.setText(String.valueOf(string4));
        Computer.setText(String.valueOf(string5));
    }
}
