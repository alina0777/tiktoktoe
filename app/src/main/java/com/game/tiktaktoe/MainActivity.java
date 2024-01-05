package com.game.tiktaktoe;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean targetSound = true;
    boolean targetChatGPT = true;
    SoundManager soundManager;
    Button buttonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        targetSound = true;
        targetChatGPT = true;

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        soundManager = new SoundManager(getApplicationContext(), R.raw.button_sound);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                soundManager.play(targetSound);

                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("targetSound", targetSound);
                intent.putExtra("targetChatGPT", targetChatGPT);
                setResult(Activity.RESULT_OK, intent);
                startActivityForResult(intent,101);
                onNewIntent (intent);

            }
        });


        ImageView soundSettingBottom = findViewById(R.id.sound_button);
        soundSettingBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                targetSound=!targetSound;

                if (targetSound) {
                    soundSettingBottom.setImageResource( R.drawable.on_sound_button);
                } else {
                    soundSettingBottom.setImageResource( R.drawable.off_sound_button);
                }


            }
        });

        ImageView chatGptButton = findViewById(R.id.chatgpt_button);
        chatGptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (targetChatGPT) {
                    chatGptButton.setImageResource( R.drawable.chatgpt_on);
                } else {
                    chatGptButton.setImageResource(R.drawable.chatgpt_off);
                }
                targetChatGPT=!targetChatGPT;
            }
        });

    }

}