package com.wah.astolfogaysounds.io

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

fun read(context: Context): Long {
    return try {
        context.openFileInput("count.txt").use { fileInputStream ->
            InputStreamReader(fileInputStream).use { inputStreamReader ->
                BufferedReader(inputStreamReader).use { bufferedReader ->
                    bufferedReader.readLine().toLong()
                }
            }
        }
    } catch (ignored: IOException) { 0L }
}

fun write(context: Context, count: Long) {
    val string = count.toString()
    try {
        context.openFileOutput("count.txt", AppCompatActivity.MODE_PRIVATE).use { fileOutputStream ->
            fileOutputStream.write(
                string.toByteArray()
            )
        }
    } catch (ignored: IOException) { }
}