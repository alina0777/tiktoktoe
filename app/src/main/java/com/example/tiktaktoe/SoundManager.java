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

    public void play(){
        mPlayer.start();
//        buttonStart.setEnabled(false);
    }

    private void stopPlay() {
        mPlayer.stop();
//        buttonStart.setEnabled(false);
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
//            buttonStart.setEnabled(true);
        } catch (Throwable t) {
            return;
        }
    }

    public void pause(View view) {
        mPlayer.pause();
//        buttonStart.setEnabled(true);
    }
    public void stop(View view) {
        stopPlay();
    }

}
