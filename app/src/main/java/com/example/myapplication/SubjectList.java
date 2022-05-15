package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        Button button_back = (Button) findViewById(R.id.button_back);

        computerVision.setOnClickListener(v -> Toast.makeText(SubjectList.this,
                "You choose Computer Vision",
                Toast.LENGTH_SHORT).show());
        maths.setOnClickListener(v -> {
            Intent intent = new Intent(SubjectList.this, Test.class);
            String subject = "Maths";
            intent.putExtra("sub",subject);
            startActivity(intent);
        });
        physics.setOnClickListener(v -> Toast.makeText(SubjectList.this,
                "You choose Physics",
                Toast.LENGTH_SHORT).show());
        databases.setOnClickListener(v -> Toast.makeText(SubjectList.this,
                "You choose Databases",
                Toast.LENGTH_SHORT).show());
        internetSecurity.setOnClickListener(v -> Toast.makeText(SubjectList.this,
                "You choose Internet Security",
                Toast.LENGTH_SHORT).show());
        button_back.setOnClickListener(view -> finish());

    }
}