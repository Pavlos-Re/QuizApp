package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SubjectList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);


        ImageView computerVision = (ImageView) findViewById(R.id.computer_vision_icon);
        ImageView maths = (ImageView) findViewById(R.id.maths_icon);
        ImageView physics = (ImageView) findViewById(R.id.physics_icon);
        ImageView databases = (ImageView) findViewById(R.id.data_bases_icon);
        ImageView internetSecurity = (ImageView) findViewById(R.id.internet_security_icon);

        computerVision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SubjectList.this,
                        "You choose Computer Vision",
                        Toast.LENGTH_SHORT).show();
            }
        });
        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SubjectList.this,
                        "You choose Maths",
                        Toast.LENGTH_SHORT).show();
            }
        });
        physics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SubjectList.this,
                        "You choose Physics",
                        Toast.LENGTH_SHORT).show();
            }
        });
        databases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SubjectList.this,
                        "You choose Databases",
                        Toast.LENGTH_SHORT).show();
            }
        });
        internetSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SubjectList.this,
                        "You choose Internet Security",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}