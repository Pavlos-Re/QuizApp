package com.example.myapplication;

import java.util.Random;

class TestInfo {

    static int prev_num = 0;
    static int rand_num = 0;

    private static final Random RANDOM = new Random();

    public static String[][] List_Questions_Maths = {{"2 + 3 = ", "5", "2","3","-1","1"},
                                   {"3 - 4 = ", "4", "7", "-1", "0", "3"},
                                    {"4 / 4 = ", "4", "0.5", "1", "0","3"},
                                    {"4 * 4 + 7 = ", "23", "44", "15", "20","1"},
                                    {"9 * ( -5 + 7 / 7 ) = ", "-35", "-30", "36", "-36","4"}
    };

    public static String[][] List_Questions_Sports = {
            {"Which is a court or lawn game played with lightweight rackets and a shuttlecock?","Tennis","Cricket","Baseball","Badminton","4"},
            {"The equipment for what sport was found in the tomb of an Egyptian child buried about 3200 BCE?","Bowling","Croquet","Boules","Billiards","1"},
            {"Episkuros, calcio, and melees were early forms of which popular sport?","Fencing","Boxing","Football","Gymnastics","3"},
            {"In which major sport is substitution allowed while the game is in play?","Ice hockey","Cricket","Volleyball","Football","1"},
            {"Yokuzuna is the highest ranking attainable in which sport?","Chess","Sumo","Judo","Buzkashi","2"}
    };

    public static String[][] List_Questions_Internet = {
            {"WWW stands for:","World Wide\nWeb","Wireless World\nWeb","World Wild\nWeb","Wonderful World\nWeb","1"},
            {"During which decade did the Internet become visible to the general public?","the 1980s","the 1970s","the 1990s","the 200s","3"},
            {"Information on the internet is shared by:","Files","Packets","Forums","Messages","2"},
            {"IP stands for:","Internet\nProtocol","Information\nPersonal","In Protocol","Internet\nPreference","1"},
            {"Which of the following are not a transport layer protocol?","IP","UDP","TCP","DCCP","1"}
    };

    public static String[][] List_Questions_Computer = {
            {"Which of the following is not a computer peripheral?","Keyboard","Mouse","Joystick","CPU","4"},
            {"Which was the first data saving storage device?","CD drive","Floppy disk drive","Williams Tube","Diode","3"},
            {"Who is thought to be the 'father' of computers?","Alan Turing","Steve jobs","Von Neumann","Charles Babbage","4"},
            {"Which of these is not a computer operating system?","Apple OS X","Photoshop","Microsoft Windows","Linux","2"},
            {"Which is the most famous OS?","Apple OS X","Photoshop","Microsoft Windows","Linux","2"}
    };

    public static String[][] List_Questions_World = {
            {"In which country are the world’s 10 coldest cities located?", "Russia", "USA","Canada","Sweden","1"},
            {"Which country has three capital cities—Pretoria, Cape Town, and Bloemfontein?","Nigeria","South Africa","Chile","Australia","2"},
            {"Thanks to its overseas territories, which country technically spans 12 time zones?","France","USA","Spain","Netherlands","1"},
            {"Which continent is home to the most countries?","Asia","Europe","Africa","South America","3"},
            {"Which of these is NOT one of the 13 countries crossed by the Equator?","Kenya","Ecuador","Indonesia","Egypt","4"}
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
