package com.example.astolfogaysounds;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;

    private ImageView mainImageView;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainImageView = findViewById(R.id.mainImageView);

        random = new Random();

        actionOnClick();
    }

    private void actionOnClick(){
        mainImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (random.nextInt(13)){
                    case 0:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_1);
                            mediaPlayer.start();
                        }
                        break;
                    }
                    case 1:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_2);
                            mediaPlayer.start();
                        }
                        break;
                    }
                    case 2:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_3);
                            mediaPlayer.start();
                        }
                        break;
                    }
                    case 3:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_4);
                            mediaPlayer.start();
                        }
                        break;
                    }
                    case 4:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_5);
                            mediaPlayer.start();
                        }
                        break;
                    }
                    case 5:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_6);
                            mediaPlayer.start();
                        }
                        break;
                    }
                    case 6:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_7);
                            mediaPlayer.start();
                        }
                        break;
                    }
                    case 7:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_8);
                            mediaPlayer.start();
                        }
                        break;
                    }
                    case 8:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_9);
                            mediaPlayer.start();
                        }
                        break;
                    }
                    case 9:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_10);
                            mediaPlayer.start();
                        }
                        break;
                    }
                    case 10:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_1);
                            mediaPlayer.start();
                        }
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_11);
                        mediaPlayer.start();
                        break;
                    }
                    case 11:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_12);
                            mediaPlayer.start();
                        }
                        break;
                    }
                    case 12:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_13);
                            mediaPlayer.start();
                        }
                        break;
                    }
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}
