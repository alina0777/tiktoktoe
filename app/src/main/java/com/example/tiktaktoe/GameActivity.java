package com.example.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameActivity extends AppCompatActivity {


    Context context ;
    boolean player1_player2 = true;

    String[][] mainArray = {    {"_","_","_"},
                                {"_","_","_"},
                                {"_","_","_"}   };

    TextView statusText;
    TextView statusText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        context = getApplicationContext();
        statusText = findViewById(R.id.statusText);
        statusText2 = findViewById(R.id.statusText2);

        System.out.println("mainArray [0]: "  + Arrays.toString(mainArray[0]));
        System.out.println("mainArray [0]: "  + Arrays.toString(mainArray[1]));
        System.out.println("mainArray [0]: "  + Arrays.toString(mainArray[2]));

        TableLayout gameTable = findViewById(R.id.gameTable);

    }

    public void onGameClick(View view)
    {
        // выводим сообщение


        Button button = (Button) view;
        String str = view.getTransitionName();

        Toast.makeText(this, "Зачем вы нажали?" + str, Toast.LENGTH_SHORT).show();

        String value = "";

        if (player1_player2 == true) {
            value = "X";
        } else {
            value = "0";
        }

        button.setText(value);

        System.out.println("xxx == " +str.charAt(0));
        System.out.println("yyy == " +str.charAt(str.length()-1));


        initMainArray( Character.getNumericValue(str.charAt(0)),        // init X
                Character.getNumericValue(str.charAt(str.length()-1)),  // init Y
                value);                                                  // init X or 0

        String result = "";

        result = checkWinner( Character. getNumericValue(str.charAt(0)),        // init X
                Character.getNumericValue(str.charAt(str.length()-1)),  // init Y
                value);

        statusText2.setText(result);

        player1_player2 = changePlayerStatus(player1_player2);
    }

    public String checkWinner(int x, int y, String value) {
        System.out.println("checkWinner");
        System.out.println("using = " + value);

        System.out.println("mainArray [0]: "  + Arrays.toString(mainArray[0]));
        System.out.println("mainArray [1]: "  + Arrays.toString(mainArray[1]));
        System.out.println("mainArray [2]: "  + Arrays.toString(mainArray[2]));

        //Проверка по горизонтали

        int countWin_X = 0;
        int countWin_0 = 0;

        for (int i = 0; i < mainArray.length; i++) {
            if (mainArray[i][y-1].equals("X")){
                countWin_X++;
            } else if (mainArray[i][y-1].equals("0")) {
                countWin_0++;
            }
        }

        if (countWin_X == 3) {
            return "Выиграли Крестики";
        } else if (countWin_0==3){
            return "Выиграли Нолики";
        }

        //Проверка по вертикали

        countWin_X = 0;
        countWin_0 = 0;

        for (int j = 0; j < mainArray.length; j++) {
            if (mainArray[x-1][j].equals("X")){
                countWin_X++;
            } else if (mainArray[x-1][j].equals("0")) {
                countWin_0++;
            }
        }

        if (countWin_X == 3) {
            return "Выиграли Крестики";
        } else if (countWin_0==3){
            return "Выиграли Нолики";
        }

        //Проверка по диагонали

        System.out.println("Проверка основной диагонали");
//
        countWin_X = 0;
        countWin_0 = 0;

        for (int i = 0; i < mainArray.length; i++) {
            for (int j = 0; j < mainArray.length; j++) {

                if (i==j)
                {
                    System.out.println("x y  = " + String.valueOf(i)  + ", "+ String.valueOf(j));

                    if (mainArray[i][j].equals("X")) {
                        countWin_X++;
                    } else if (mainArray[i][y-1].equals("0")) {
                        countWin_0++;
                    }
                }
            }
        }

        if (countWin_X == 3) {
            return "Выиграли Крестики";
        } else if (countWin_0 == 3){
            return "Выиграли Нолики";
        }


        //Проверка по обратной диагонали
        System.out.println("Проверка обратной диагонали");

        countWin_X = 0;
        countWin_0 = 0;

        for (int i = 0; i < mainArray.length; i++) {
            System.out.println("x y  = " + String.valueOf(i)  + ", "+ String.valueOf(mainArray.length-1-i));

            if (mainArray[i][mainArray.length-1-i].equals("X")) {
                countWin_X++;
            } else if (mainArray[i][mainArray.length-1-i].equals("0")) {
                countWin_0++;
            }

        }

        if (countWin_X == 3) {
            return "Выиграли Крестики";
        } else if (countWin_0 == 3){
            return "Выиграли Нолики";
        }

        return "";
    }

    public void initMainArray(int x, int y, String value) {

        System.out.println("initMainArray");

        System.out.println("X = " +  String.valueOf(x));
        System.out.println("Y = " +  String.valueOf(y));



        mainArray[x-1][y-1] = value;

        System.out.println("mainArray [0]: "  + Arrays.toString(mainArray[0]));
        System.out.println("mainArray [1]: "  + Arrays.toString(mainArray[1]));
        System.out.println("mainArray [2]: "  + Arrays.toString(mainArray[2]));

    }

    public boolean changePlayerStatus(boolean status){

        if (status){
            statusText.setText("Ходят нолики");

        } else {
            statusText.setText("Ходят крестики");

        }

        status = !status;
        return status;
    }
}