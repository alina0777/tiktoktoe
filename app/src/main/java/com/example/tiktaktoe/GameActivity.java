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

public class GameActivity extends AppCompatActivity {


    Context context ;
    boolean player1_player2 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        context = getApplicationContext();


        TableLayout gameTable = findViewById(R.id.gameTable);



    }

    public void onGameClick(View view)
    {
        // выводим сообщение


        Button button = (Button) view;
        String str = view.getTransitionName();

        Toast.makeText(this, "Зачем вы нажали?" + str, Toast.LENGTH_SHORT).show();

        if (player1_player2 == true)
            button.setText("X");
        else
            button.setText("0");

        player1_player2 = changePlayerStatus(player1_player2);
    }

    public boolean changePlayerStatus(boolean status){

        TextView statusText = findViewById(R.id.statusText);

        if (status){
            statusText.setText("Ходят нолики");

        } else {
            statusText.setText("Ходят крестики");

        }

        status = !status;
        return status;
    }
}