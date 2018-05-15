package com.example.vitaliy.ppctfmp4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView videoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intent = getIntent();
        int videoID = intent.getIntExtra(MainActivity.DATA_SOURCE, -1);

        videoPlayer = findViewById(R.id.videoView);
        Uri trackUri = Uri.parse( "android.resource://" + getPackageName() + "/" + videoID);
        videoPlayer.setVideoURI(trackUri);

        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);

        Button bPlay = findViewById(R.id.buttonPlay2);
        Button bPause = findViewById(R.id.buttonPause2);
        Button bStop = findViewById(R.id.buttonStop2);

        bPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                videoPlayer.start();
            }
        });

        bPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                videoPlayer.pause();
            }
        });

        bStop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                videoPlayer.stopPlayback();
                videoPlayer.resume();
            }
        });
    }

}
