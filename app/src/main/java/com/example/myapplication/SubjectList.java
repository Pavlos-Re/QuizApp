package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SubjectList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);

        ImageView computer = findViewById(R.id.computer_icon);
        ImageView maths = findViewById(R.id.maths_icon);
        ImageView internet = findViewById(R.id.internet_icon);
        ImageView sports = findViewById(R.id.sports_icon);
        ImageView world = findViewById(R.id.world_icon);

        computer.setOnClickListener(v -> {
            Intent intent = new Intent(SubjectList.this, Test.class);
            String subject = "Computer";
            intent.putExtra("sub",subject);
            startActivity(intent);
        });
        maths.setOnClickListener(v -> {
            Intent intent = new Intent(SubjectList.this, Test.class);
            String subject = "Maths";
            intent.putExtra("sub",subject);
            startActivity(intent);
        });
        internet.setOnClickListener(v -> {
            Intent intent = new Intent(SubjectList.this, Test.class);
            String subject = "Internet";
            intent.putExtra("sub",subject);
            startActivity(intent);
        });
        world.setOnClickListener(v -> {
            Intent intent = new Intent(SubjectList.this, Test.class);
            String subject = "World";
            intent.putExtra("sub",subject);
            startActivity(intent);
        });
        sports.setOnClickListener(v -> {
            Intent intent = new Intent(SubjectList.this, Test.class);
            String subject = "Sports";
            intent.putExtra("sub",subject);
            startActivity(intent);
        });

    }

}