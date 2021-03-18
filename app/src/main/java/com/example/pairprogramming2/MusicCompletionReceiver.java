package com.example.pairprogramming2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MusicCompletionReceiver extends BroadcastReceiver {

    MainActivity mainActivity;
    public MusicCompletionReceiver(){
        //empty constructor
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String musicName = intent.getStringExtra(MusicService.MUSICNAME);
        mainActivity.updateName(musicName);
    }

    public MusicCompletionReceiver(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }



}
