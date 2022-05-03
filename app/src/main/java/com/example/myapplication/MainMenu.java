package com.example.myapplication;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.Random;

public class MainMenu extends AppCompatActivity {
    private static final Random RANDOM = new Random(); //this will be used for the random fun fact
    private static Context context; //creating context to get the string from the xml file


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        final MediaPlayer media2 = MediaPlayer.create(this, R.raw.pop);
        setContentView(R.layout.activity_main_menu);
        Button button_fact = (Button) findViewById(R.id.fact_button);
        //the function that prints the fun fact in the textview will be called when the button is clicked
        button_fact.setOnClickListener(v -> {
            media2.start();
            getFact();
        });
        Button button_subject = (Button) findViewById(R.id.choose_subject_button);
        button_subject.setOnClickListener(v -> {
            media2.start();
        });
        Button button_high_score = (Button) findViewById(R.id.check_highscores_button);
        button_high_score.setOnClickListener(v -> {
            media2.start();
        });
        }
        //adding functionality for the back-button of
    @Override
    public void onBackPressed() {
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
        ImageView image = findViewById(R.id.smart_pic);
        image.setVisibility(View.VISIBLE);
    }
    }




