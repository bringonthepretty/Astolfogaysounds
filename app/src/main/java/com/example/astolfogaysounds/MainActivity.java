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

    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;
    private MediaPlayer mediaPlayer4;
    private MediaPlayer mediaPlayer5;
    private MediaPlayer mediaPlayer6;
    private MediaPlayer mediaPlayer7;
    private MediaPlayer mediaPlayer8;
    private MediaPlayer mediaPlayer9;
    private MediaPlayer mediaPlayer10;
    private MediaPlayer mediaPlayer11;
    private MediaPlayer mediaPlayer12;
    private MediaPlayer mediaPlayer13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainImageView = findViewById(R.id.mainImageView);

        random = new Random();

        mediaPlayer1 = MediaPlayer.create(this, R.raw.gay_sound_1);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.gay_sound_2);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.gay_sound_3);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.gay_sound_4);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.gay_sound_5);
        mediaPlayer6 = MediaPlayer.create(this, R.raw.gay_sound_6);
        mediaPlayer7 = MediaPlayer.create(this, R.raw.gay_sound_7);
        mediaPlayer8 = MediaPlayer.create(this, R.raw.gay_sound_8);
        mediaPlayer9 = MediaPlayer.create(this, R.raw.gay_sound_9);
        mediaPlayer10 = MediaPlayer.create(this, R.raw.gay_sound_10);
        mediaPlayer11 = MediaPlayer.create(this, R.raw.gay_sound_11);
        mediaPlayer12 = MediaPlayer.create(this, R.raw.gay_sound_12);
        mediaPlayer13 = MediaPlayer.create(this, R.raw.gay_sound_13);

        actionOnClick();
    }

    private void actionOnClick(){
        mainImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (random.nextInt(13)){
                    case 0:{
                        mediaPlayer1.start();
                        break;
                    }
                    case 1:{
                        mediaPlayer2.start();
                        break;
                    }
                    case 2:{
                        mediaPlayer3.start();
                        break;
                    }
                    case 3:{
                        mediaPlayer4.start();
                        break;
                    }
                    case 4:{
                        mediaPlayer5.start();
                        break;
                    }
                    case 5:{
                        mediaPlayer6.start();
                        break;
                    }
                    case 6:{
                        mediaPlayer7.start();
                        break;
                    }
                    case 7:{
                        mediaPlayer8.start();
                        break;
                    }
                    case 8:{
                        mediaPlayer9.start();
                        break;
                    }
                    case 9:{
                        mediaPlayer10.start();
                        break;
                    }
                    case 10:{
                        mediaPlayer11.start();
                        break;
                    }
                    case 11:{
                        mediaPlayer12.start();
                        break;
                    }
                    case 12:{
                        mediaPlayer13.start();
                        break;
                    }
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer1.release();
        mediaPlayer2.release();
        mediaPlayer3.release();
        mediaPlayer4.release();
        mediaPlayer5.release();
        mediaPlayer6.release();
        mediaPlayer7.release();
        mediaPlayer8.release();
        mediaPlayer9.release();
        mediaPlayer10.release();
        mediaPlayer11.release();
        mediaPlayer12.release();
        mediaPlayer13.release();
    }
}
