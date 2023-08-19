package com.wah.astolfogaysounds

import android.content.res.Resources.NotFoundException
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import kotlin.random.Random

open class MainActivity : AppCompatActivity() {

    private val random: Random = Random.Default

    private lateinit var imageView: ImageView
    private lateinit var counterTextView: TextView

    private lateinit var mediaPlayer: MediaPlayer

    private var counter = 0L
    private var oldRandomValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.mainImageView)
        counterTextView = findViewById(R.id.counterTextView)

        counter = try {
            read()
        } catch (e: NotFoundException) {
            0
        }

        counterTextView.text = counter.toString()
        mediaPlayer = MediaPlayer.create(this, R.raw.gay_sound_1)

        if (counter >= 100L) {
            val actionBar = supportActionBar!!
            actionBar.subtitle = "I'm on my way to thousands clicks"
        }

        if (counter >= 2000L) {
            val actionBar = supportActionBar!!
            actionBar.subtitle = "Real world is nothing to me"
        }

        if (counter >= 50000L) {
            val actionBar = supportActionBar!!
            actionBar.title = "I'm idiot"
        }

        actionOnClick()
    }

    override fun onPause() {
        super.onPause()
        write(counter)
        mediaPlayer.stop()
    }

    fun actionOnClick() {
        imageView.setOnClickListener {
            var randomValue: Int

            do {
                randomValue = random.nextInt(13)
            } while (randomValue == oldRandomValue)

            if (!mediaPlayer.isPlaying) {
                val resourceCode = when (randomValue) {
                    1 -> R.raw.gay_sound_2
                    2 -> R.raw.gay_sound_3
                    3 -> R.raw.gay_sound_4
                    4 -> R.raw.gay_sound_5
                    5 -> R.raw.gay_sound_6
                    6 -> R.raw.gay_sound_7
                    7 -> R.raw.gay_sound_8
                    8 -> R.raw.gay_sound_9
                    9 -> R.raw.gay_sound_10
                    10 -> R.raw.gay_sound_11
                    11 -> R.raw.gay_sound_12
                    12 -> R.raw.gay_sound_13
                    else -> R.raw.gay_sound_1
                }
                mediaPlayer = MediaPlayer.create(this, resourceCode)
                mediaPlayer.start()
                oldRandomValue = randomValue
            }

            counter++
            counterTextView.text = counter.toString()

            if (counter == 100L) {
                Toast.makeText(this, "nice start!", Toast.LENGTH_LONG).show()
            }

            if (counter == 1000L) {
                Toast.makeText(
                    this, "unhinged", Toast.LENGTH_LONG).show()
            }

            if (counter == 2000L) {
                Toast.makeText(
                    this, "omg fuck off", Toast.LENGTH_LONG).show()
            }

            if (counter == 10000L) {
                Toast.makeText(this, "actual cringe", Toast.LENGTH_LONG).show()
            }

            if (counter == 20000L) {
                Toast.makeText(this, "u gud bro?", Toast.LENGTH_LONG).show()
            }

            if (counter == 50000L) {
                Toast.makeText(
                    this, "nonce. cunt. degenerate. gay. go fuck yourself",
                        Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun read(): Long {
        var count: Long = 0
        try {
            openFileInput("count.txt").use { fileInputStream ->
                InputStreamReader(fileInputStream).use { inputStreamReader ->
                    BufferedReader(inputStreamReader).use { bufferedReader ->
                        count = bufferedReader.readLine().toLong()
                    }
                }
            }
        } catch (ignored: IOException) { }
        return count
    }

    private fun write(count: Long) {
        val string = count.toString()
        try {
            openFileOutput("count.txt", MODE_PRIVATE).use { fileOutputStream ->
                fileOutputStream.write(
                    string.toByteArray()
                )
            }
        } catch (ignored: IOException) { }
    }

}