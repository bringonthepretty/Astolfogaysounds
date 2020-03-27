package com.example.astolfogaysounds;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        if (counter >= 50000L){
            ActionBar actionBar = getSupportActionBar();
            assert actionBar != null;
            actionBar.setTitle("I'm idiot");
        }

        if (counter >= 100L){
            ActionBar actionBar = getSupportActionBar();
            assert actionBar != null;
            actionBar.setSubtitle("I'm on my way to thousands clicks");
        }

        if (counter >= 2000L){
            ActionBar actionBar = getSupportActionBar();
            assert actionBar != null;
            actionBar.setSubtitle("Real world is nothing to me");
        }

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

                switch (randomValue){
                    case 0:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_1);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                    case 1:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_2);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                    case 2:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_3);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                    case 3:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_4);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                    case 4:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_5);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                    case 5:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_6);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                    case 6:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_7);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                    case 7:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_8);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                    case 8:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_9);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                    case 9:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_10);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                    case 10:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_11);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                    case 11:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_12);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                    case 12:{
                        if (!mediaPlayer.isPlaying()){
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gay_sound_13);
                            mediaPlayer.start();
                            oldRandomValue = randomValue;
                        }
                        break;
                    }
                }

                counter++;
                countTextView.setText(String.valueOf(counter));

                if (counter == 100L){
                    Toast.makeText(MainActivity.this, "nice start!", Toast.LENGTH_LONG).show();
                }

                if (counter == 2000L){
                    Toast.makeText(MainActivity.this, "enough. you'd rather read a book", Toast.LENGTH_LONG).show();
                }

                if (counter == 10000L){
                    Toast.makeText(MainActivity.this, "why are you still here?", Toast.LENGTH_LONG).show();
                }

                if (counter == 50000L){
                    Toast.makeText(MainActivity.this, "are you alright? call an ambulance? or maybe 911?", Toast.LENGTH_LONG).show();
                }
                write(counter);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(MainActivity.this, "special thanks to shino skk and pixel (yuxian)", Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
}
