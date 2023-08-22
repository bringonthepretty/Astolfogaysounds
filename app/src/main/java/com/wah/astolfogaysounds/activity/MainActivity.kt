package com.wah.astolfogaysounds.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wah.astolfogaysounds.R
import com.wah.astolfogaysounds.io.read
import com.wah.astolfogaysounds.io.write
import kotlin.random.Random

open class MainActivity: AppCompatActivity() {

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

        counter = read(this)

        counterTextView.text = counter.toString()
        mediaPlayer = MediaPlayer.create(this, R.raw.gay_sound_1)

        setTitle()
        setActionOnClick()
    }

    override fun onPause() {
        super.onPause()
        write(this, counter)
        mediaPlayer.stop()
    }

    private fun setTitle() {
        val text = when (counter) {
            in 1000L .. 4999L -> "Real world is nothing to me"
            in 5000L .. 9999L -> "I'm so retarded"
            in 10000L .. 24999L -> "I'd lick Astolfo's feet"
            in 25000L .. 49999L -> "Why would I ever talk to a woman"
            in 50000L .. Long.MAX_VALUE -> "I spent 5 hours jerking of to Astolfo"
            else -> null
        }

        if (text != null && supportActionBar != null) {
            supportActionBar!!.title = text
        }
    }

    private fun setActionOnClick() {
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

            makeToastIfNecessary()
        }
    }

    private fun makeToastIfNecessary() {
        val text = when (counter) {
            100L -> "nice start!"
            1000L -> "unhinged"
            5000L -> "omg piss off"
            10000L -> "actual cringe"
            25000L -> "u gud bro?"
            50000L -> "nonce. cunt. degenerate. gay. go fuck yourself"
            else -> null
        }

        text?.let { Toast.makeText(this, it, Toast.LENGTH_LONG).show() }
    }
}