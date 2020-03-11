package com.example.astolfogaysounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;

    private ImageView imageView;
    private long counter = 0;
    private TextView countTextView;
    private int oldRandomValue;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.mainImageView);
        countTextView = findViewById(R.id.counterTextView);

        try {
            counter = read();
        } catch (Resources.NotFoundException e){
            counter = 0;
        }

        countTextView.setText(String.valueOf(counter));

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_1);

        random = new Random();

        actionOnClick();
    }

    private void actionOnClick(){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomValue;

                do {
                    randomValue = random.nextInt( 13);
                } while(randomValue == oldRandomValue);
                oldRandomValue = randomValue;

                switch (randomValue){
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
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_11);
                            mediaPlayer.start();
                        }
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

                counter++;
                countTextView.setText(String.valueOf(counter));
                write(counter);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    public long read() throws Resources.NotFoundException{
        long count = 0;
        try {
            FileInputStream fileInputStream = openFileInput("count.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            count = Long.parseLong(bufferedReader.readLine());
        } catch (FileNotFoundException ignored) {

        } catch (IOException ignored) {

        }
        return count;
    }

    private void write(long count){

        String string = String.valueOf(count);

        try {
            FileOutputStream fileOutputStream = openFileOutput("count.txt", MODE_PRIVATE);
            fileOutputStream.write(string.getBytes());
        } catch (FileNotFoundException ignored) {
        } catch (IOException ignored) {
        }
    }
}
