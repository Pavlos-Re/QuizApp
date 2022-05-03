package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;


import java.util.Random;

public class MainMenu extends AppCompatActivity {
    private static final Random RANDOM = new Random();
    private static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main_menu);

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


        TextView fun = (TextView)findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.fact_button);
        button.setOnClickListener(v -> {
            int fun_fact = RANDOM.nextInt(FACTS.length);
            fun.setText(FACTS[fun_fact]);

        });
        }
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
    }




