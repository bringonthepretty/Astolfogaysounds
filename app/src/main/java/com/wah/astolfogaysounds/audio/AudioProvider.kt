package com.wah.astolfogaysounds.audio

import android.content.Context
import android.media.MediaPlayer
import java.util.stream.Collectors

/**
 * This class represents audio provider.
 * init() must be called once before playRandom() and after every stopAndReleaseAll() call
 */
class AudioProvider (private val audioResourcesList: List<Int>, private val context: Context) {

    private lateinit var mediaPlayers: List<MediaPlayer>

    fun init() {
        mediaPlayers = audioResourcesList.stream()
            .map { resource -> MediaPlayer.create(context, resource) }
            .collect(Collectors.toCollection(::ArrayList))
    }

    fun playRandom() {
        if (mediaPlayers.stream().allMatch { mediaPlayer -> !mediaPlayer.isPlaying }) {
            mediaPlayers.random().start()
        }
    }

    fun stopAndReleaseAll() {
        mediaPlayers.forEach {
            it.stop()
            it.release()
        }
    }
}