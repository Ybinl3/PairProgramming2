package com.example.pairprogramming2;

import android.media.MediaPlayer;

public class MusicPlayer implements MediaPlayer.OnCompletionListener{

    MediaPlayer player;
    int currentPosition = 0;
    int musicIndex = 0;
    private int musicStatus = 0;
    private MusicService musicService;

    static final int[] MUSICPATH = new int[]{
            R.raw.gotechgo,
            R.raw.mario,
            R.raw.tetris
    };
    static final String[] MUSICNAME = new String[]{
            "Go Tech Go!",
            "Super Mario Brothers",
            "Tetris"
    };
    public MusicPlayer(MusicService service){
        this.musicService = service;
    }
    public int getMusicStatus(){
        return musicStatus;
    }
    public String getMusicName(){
        return MUSICNAME[musicIndex];
    }
    public void playMusic(){
        player = MediaPlayer.create(this.musicService, MUSICPATH[musicIndex]);


    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }
}
