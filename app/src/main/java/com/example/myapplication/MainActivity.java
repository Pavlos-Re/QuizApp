package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity extends localeHelper {

    MediaPlayer media;
    Button button;
    Button button2;
    Button button3;
    Button button4;
    ImageView gr;
    ImageView en;
    int backButtonCount = 0;
    boolean homePressed = false;
    EditText e1, e2;
    TextView t1;
    int num1, num2;
    private static Context context;
    String current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        current = Locale.getDefault().getLanguage();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reminderNotification();
        context = getBaseContext();
        final Button send = (Button) this.findViewById(R.id.button);

        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.i("SendMailActivity", "Send Button Clicked.");

                String fromEmail = "quizappmp@gmail.com";
                String fromPassword = "QuizApp12345";
                String toEmails = ((TextView) findViewById(R.id.editText))
                        .getText().toString();
                List toEmailList = Arrays.asList(toEmails
                        .split("\\s*,\\s*"));
                Log.i("SendMailActivity", "To List: " + toEmailList);
                String emailSubject = "Your Test results";
                String emailBody = "Your test results indicate that blah blah blah";
                new SendMailTask(MainActivity.this).execute(fromEmail,
                        fromPassword, toEmailList, emailSubject, emailBody);
            }
        });



        //change actionbar title, if you dont change it will be according to your sustems default lang
        //ActionBar actionBar = getSupportActionBar();

        //Drawable d = Drawable.createFromPath(R.drawable.databases);
        final MediaPlayer media2 = MediaPlayer.create(MainActivity.this, R.raw.pop );
        media = MediaPlayer.create(this, R.raw.street_soul);

        button = findViewById(R.id.button_begin);
        button2 = findViewById(R.id.button_sound_on_off);
        button3 = findViewById(R.id.button_about);
        button4 = findViewById(R.id.button_calc);
        gr = findViewById(R.id.greek_flag);
        en = findViewById(R.id.uk_flag);

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


        button4.setOnClickListener(v -> {
            media2.start();
            Intent intent3 = new Intent(MainActivity.this, Calculator.class);
            startActivity(intent3);
        });

        gr.setOnClickListener(v -> {
            media2.start();

            if(!current.equals("el")) {
                media.stop();
                localeHelper.setLocale(this, "el");
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                finish();
            }
        });
        en.setOnClickListener(v -> {

            media2.start();
            if(!current.equals("en")) {
                media.stop();
                localeHelper.setLocale(this, "en");
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                finish();
            }
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

        //actionBar.setTitle(getResources().getString(R.string.app_name));

    }
    public void reminderNotification()
    {
        NotificationUtils _notificationUtils = new NotificationUtils(this);
        long _currentTime = System.currentTimeMillis();
        long oneSecond = 1000;
        _notificationUtils.setReminder(oneSecond);
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(localeHelper.onAttach(base, "en"));
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
    public static Context getAppContext() {
        return context;
    }

}