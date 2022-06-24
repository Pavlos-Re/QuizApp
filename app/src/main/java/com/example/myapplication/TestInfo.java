package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;
import java.util.Random;

class TestInfo extends AppCompatActivity {
    private static Context context;
    static int prev_num = 0;
    static int rand_num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    private Locale currentLocal = null;


    private  final Random RANDOM = new Random();

    public  String[][] List_Questions_Maths = {{"2 + 3 = ", "5", "2","3","-1","1"},
                                   {"3 - 4 = ", "4", "7", "-1", "0", "3"},
                                    {"4 / 4 = ", "4", "0.5", "1", "0","3"},
                                    {"4 * 4 + 7 = ", "23", "44", "15", "20","1"},
                                    {"9 * ( -5 + 7 / 7 ) = ", "-35", "-30", "36", "-36","4"}
    };
    public static Context getContext(){
        return context;
    }

    public  String[][] List_Questions_Sports = {
            {MainActivity.getStringGlobal(R.string.sports1),MainActivity.getStringGlobal(R.string.s_a1),MainActivity.getStringGlobal(R.string.s_a2),MainActivity.getStringGlobal(R.string.s_a3),MainActivity.getStringGlobal(R.string.s_a4),"4"},
            {MainActivity.getStringGlobal(R.string.sports2),MainActivity.getStringGlobal(R.string.s_a5),MainActivity.getStringGlobal(R.string.s_a6),MainActivity.getStringGlobal(R.string.s_a7),MainActivity.getStringGlobal(R.string.s_a8),"1"},
            {MainActivity.getStringGlobal(R.string.sports3),MainActivity.getStringGlobal(R.string.s_a9),MainActivity.getStringGlobal(R.string.s_a10),MainActivity.getStringGlobal(R.string.s_a11),MainActivity.getStringGlobal(R.string.s_a12),"3"},
            {MainActivity.getStringGlobal(R.string.sports4),MainActivity.getStringGlobal(R.string.s_a13),MainActivity.getStringGlobal(R.string.s_a2),MainActivity.getStringGlobal(R.string.s_a14),MainActivity.getStringGlobal(R.string.s_a11),"1"},
            {MainActivity.getStringGlobal(R.string.sports5),MainActivity.getStringGlobal(R.string.s_a15),MainActivity.getStringGlobal(R.string.s_a16),MainActivity.getStringGlobal(R.string.s_a17),MainActivity.getStringGlobal(R.string.s_a18),"2"}
    };

    public  String[][] List_Questions_Internet = {
            {MainActivity.getStringGlobal(R.string.internet1),MainActivity.getStringGlobal(R.string.i_a1),MainActivity.getStringGlobal(R.string.i_a2),MainActivity.getStringGlobal(R.string.i_a3),MainActivity.getStringGlobal(R.string.i_a4),"1"},
            {MainActivity.getStringGlobal(R.string.internet2),MainActivity.getStringGlobal(R.string.i_a5),MainActivity.getStringGlobal(R.string.i_a6),MainActivity.getStringGlobal(R.string.i_a7),MainActivity.getStringGlobal(R.string.i_a8),"2"},
            {MainActivity.getStringGlobal(R.string.internet3),MainActivity.getStringGlobal(R.string.i_a9),MainActivity.getStringGlobal(R.string.i_a10),MainActivity.getStringGlobal(R.string.i_a11),MainActivity.getStringGlobal(R.string.i_a12),"1"},
            {MainActivity.getStringGlobal(R.string.internet4),MainActivity.getStringGlobal(R.string.i_a13),MainActivity.getStringGlobal(R.string.i_a14),MainActivity.getStringGlobal(R.string.i_a15),MainActivity.getStringGlobal(R.string.i_a16),"1"},
            {MainActivity.getStringGlobal(R.string.internet5),MainActivity.getStringGlobal(R.string.i_a17),MainActivity.getStringGlobal(R.string.i_a18),MainActivity.getStringGlobal(R.string.i_a19),MainActivity.getStringGlobal(R.string.i_a20),"1"}
    };

    public  String[][] List_Questions_Computer = {
            {MainActivity.getStringGlobal(R.string.computer1),MainActivity.getStringGlobal(R.string.c_a1),MainActivity.getStringGlobal(R.string.c_a2),MainActivity.getStringGlobal(R.string.c_a3),MainActivity.getStringGlobal(R.string.c_a4),"4"},
            {MainActivity.getStringGlobal(R.string.computer2),MainActivity.getStringGlobal(R.string.c_a5),MainActivity.getStringGlobal(R.string.c_a6),MainActivity.getStringGlobal(R.string.c_a7),MainActivity.getStringGlobal(R.string.c_a8),"3"},
            {MainActivity.getStringGlobal(R.string.computer3),MainActivity.getStringGlobal(R.string.c_a9),MainActivity.getStringGlobal(R.string.c_a10),MainActivity.getStringGlobal(R.string.c_a11),MainActivity.getStringGlobal(R.string.c_a12),"4"},
            {MainActivity.getStringGlobal(R.string.computer4),MainActivity.getStringGlobal(R.string.c_a13),MainActivity.getStringGlobal(R.string.c_a14),MainActivity.getStringGlobal(R.string.c_a15),MainActivity.getStringGlobal(R.string.c_a16),"2"},
            {MainActivity.getStringGlobal(R.string.computer5),MainActivity.getStringGlobal(R.string.c_a13),MainActivity.getStringGlobal(R.string.c_a14),MainActivity.getStringGlobal(R.string.c_a15),MainActivity.getStringGlobal(R.string.c_a16),"3"}
    };

    public  String[][] List_Questions_World = {
            {MainActivity.getStringGlobal(R.string.world1),MainActivity.getStringGlobal(R.string.w_a1),MainActivity.getStringGlobal(R.string.w_a2),MainActivity.getStringGlobal(R.string.w_a3),MainActivity.getStringGlobal(R.string.w_a4),"1"},
            {MainActivity.getStringGlobal(R.string.world2),MainActivity.getStringGlobal(R.string.w_a5),MainActivity.getStringGlobal(R.string.w_a6),MainActivity.getStringGlobal(R.string.w_a7),MainActivity.getStringGlobal(R.string.w_a8),"2"},
            {MainActivity.getStringGlobal(R.string.world3),MainActivity.getStringGlobal(R.string.w_a9),MainActivity.getStringGlobal(R.string.w_a10),MainActivity.getStringGlobal(R.string.w_a11),MainActivity.getStringGlobal(R.string.w_a12),"1"},
            {MainActivity.getStringGlobal(R.string.world4),MainActivity.getStringGlobal(R.string.w_a13),MainActivity.getStringGlobal(R.string.w_a14),MainActivity.getStringGlobal(R.string.w_a15),MainActivity.getStringGlobal(R.string.w_a16),"3"},
            {MainActivity.getStringGlobal(R.string.world5),MainActivity.getStringGlobal(R.string.w_a17),MainActivity.getStringGlobal(R.string.w_a18),MainActivity.getStringGlobal(R.string.w_a19),MainActivity.getStringGlobal(R.string.w_a20),"4"}
    };


    public  int setQuestion() {

        prev_num = rand_num;

        rand_num = RANDOM.nextInt(List_Questions_Maths.length);

        if (prev_num == rand_num) {
            rand_num = RANDOM.nextInt(List_Questions_Maths.length);
        }

        return rand_num;
    }


}
