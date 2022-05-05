package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer media;
    Button button;
    Button button2;
    Button button3;
    Button button4;
    int backButtonCount = 0;
    boolean homePressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer media2 = MediaPlayer.create(MainActivity.this, R.raw.pop );
        media = MediaPlayer.create(this, R.raw.street_soul);
        button = findViewById(R.id.button_begin);
        button2 = findViewById(R.id.button_sound_on_off);
        button3 = findViewById(R.id.button_about);

        button.setOnClickListener(v -> {
            media2.start();
            Intent intent = new Intent(MainActivity.this, MainMenu.class);
            startActivity(intent);
        });
        button3.setOnClickListener(v -> {
            media2.start();
            Intent intent2 = new Intent(MainActivity.this, About.class);
            startActivity(intent2);
        });

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
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        homePressed = true;
        button2 = findViewById(R.id.button_sound_on_off);
        if(!media.isPlaying())
        button2.setText(R.string.app_off_mus);
        System.out.println("Status: OnResume");
    }

    @Override
    public void onBackPressed() {
        homePressed = false;
        System.out.println("Status: OnBackPressed");
        if (backButtonCount >= 1) {
            if (media != null) media.pause();
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

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("Status: OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Status: OnDestroy");
    }

}