package com.example.myapplication;

import java.util.Random;

class TestInfo {

    static int prev_num = 0;
    static int rand_num = 0;

    private static final Random RANDOM = new Random();

    public static String List_Questions_Maths[][] = {{"2 + 3 = ", "5", "2","3","-1","1"},
                                    {"3 - 4 = ", "4", "7", "-1", "0", "3"},
                                    {"4 / 4 = ", "4", "0.7", "1", "0","3"},
                                    {"4 * 4 + 7 = ", "23", "44", "15", "20","1"},
                                    {"9 * ( -5 + 7 / 7 ) = ", "-35", "-30", "36", "-36","4"}
    };

    public static int setQuestion() {

        prev_num = rand_num;

        rand_num = RANDOM.nextInt(List_Questions_Maths.length);

        if (prev_num == rand_num) {
            rand_num = RANDOM.nextInt(List_Questions_Maths.length);
        }

        return rand_num;
    }

}
