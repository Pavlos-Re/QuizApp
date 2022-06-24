package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.StringRes;

import java.lang.ref.WeakReference;
import java.util.Locale;

public class MainActivity extends localeHelper {
    private static WeakReference<Resources> res;
    MediaPlayer media;
    Button button;
    Button button2;
    Button button3;
    ImageView gr;
    ImageView en;
    int backButtonCount = 0;
    boolean homePressed = false;
    private static Context context;
    String current;
    protected static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        current = Locale.getDefault().getLanguage();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = new WeakReference<>(getResources());
        instance=this;
        reminderNotification();
        context = getBaseContext();

        final MediaPlayer media2 = MediaPlayer.create(MainActivity.this, R.raw.pop );
        media = MediaPlayer.create(this, R.raw.street_soul);

        button = findViewById(R.id.button_begin);
        button2 = findViewById(R.id.button_sound_on_off);
        button3 = findViewById(R.id.button_about);
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


    }
    public void reminderNotification()
    {
        NotificationUtils _notificationUtils = new NotificationUtils(this);
        long _currentTime = System.currentTimeMillis();
        long oneSecond = 1000; //after one second display noti
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
    //this method is used in the TestInfo class so that we can use the string resources there.
    //the reason why this is needed is because it is impossible to get the correct context in that class,
    //and without the context we can't have access to the string resources.
    public static String getStringGlobal(@StringRes int resId) {
            return res.get().getString(resId);
        }




}