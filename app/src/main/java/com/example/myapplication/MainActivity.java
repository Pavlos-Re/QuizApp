package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int backButtonCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final MediaPlayer media2 = MediaPlayer.create(this, R.raw.pop);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_begin);
        Button button2 = findViewById(R.id.button_sound_on_off);


        button.setOnClickListener(v -> {
            media2.start();
            Intent intent = new Intent(MainActivity.this, MainMenu.class);
            startActivity(intent);
        });
        final MediaPlayer media = MediaPlayer.create(this, R.raw.street_soul);

        media.setLooping(true);
        button2.setOnClickListener(v -> {

            if (!media.isPlaying()) {
                button2.setText(R.string.app_on_mus);
                media2.start();
                media.start();

            } else {
                media.pause();
                media2.start();
                button2.setText(R.string.app_off_mus);
            }
        });

    }




    @Override
    public void onBackPressed() {
        if (backButtonCount >= 1) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            backButtonCount=0;
        } else {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }

}