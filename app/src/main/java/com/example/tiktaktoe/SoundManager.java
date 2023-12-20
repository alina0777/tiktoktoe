package com.example.tiktaktoe;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

public class SoundManager {
    MediaPlayer mPlayer;

    SoundManager (Context context,int resid) {
        createMediaRecorder(context, resid);
    }

    public void createMediaRecorder(Context context, int resid) {
        mPlayer = MediaPlayer.create(context, resid);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                stopPlay();
            }
        });
    }

    public void play(boolean targetSound){
        if (targetSound){
            mPlayer.start();
        }

    }

    private void stopPlay() {
        mPlayer.stop();
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
        } catch (Throwable t) {
            return;
        }
    }

    public void pause(View view) {
        mPlayer.pause();
    }
    public void stop(View view) {

        stopPlay();
    }

}
