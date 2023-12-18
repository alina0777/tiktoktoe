package com.example.tiktaktoe;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.media.MediaPlayer;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

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

                soundManager.play();

                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("property", "");
                setResult(Activity.RESULT_OK, intent);
                startActivityForResult(intent,101);
                onNewIntent (intent);

            }
        });


        ImageView soundSettingBottom = findViewById(R.id.sound_button);
        soundSettingBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (targetSound) {
                    soundSettingBottom.setImageResource( R.drawable.on_sound_button);
                } else {
                    soundSettingBottom.setImageResource( R.drawable.off_sound_button);
                }

                targetSound=!targetSound;
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