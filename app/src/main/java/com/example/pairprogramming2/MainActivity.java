package com.example.pairprogramming2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Textview music;
    Button playButton;
    Button prev;
    Button next;

    MusicService musicService;
    MusicCompletionReceiver musicCompletionReceiver;
    Intent startMusicServiceIntent;
    boolean isBound = false;
    boolean isInitialized = false;

    public static final String INITIALIZE_STATUS = "initialization status";
    public static final String MUSIC_PLAYING = "music playing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music = (TextView) findViewById(R.id.music);
        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(this);
        prev = (Button) findViewById(R.id.prev);
        prev.setOnClickListener(this);
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);

        if(savedInstanceState != null){
            isInitialized = savedInstanceState.getBoolean(INITIALIZE_STATUS);
            music.setText(savedInstanceState.getString(MUSIC_PLAYING));
        }

        startMusicServiceIntent = new Intent(this, MusicService.class);

        if(!isInitialized){
            startService(startMusicServiceIntent);
            isInitialized = true;
        }

        musicCompletionReceiver = new MusicCompletionReceiver(this);
    }

    @Override


}