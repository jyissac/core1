package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.util.Log
import androidx.core.content.ContextCompat
import android.media.MediaPlayer
import androidx.fragment.app.FragmentActivity

class MainActivity : AppCompatActivity() {


    private var x = 0
    private var mMediaPlayer: MediaPlayer? = null


    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("stag", "onSaveInstanceState: ")
        outState.putInt("X", x)
        super.onSaveInstanceState(outState)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("stag","onCreat:")
        if(savedInstanceState!=null){
            x=savedInstanceState.getInt("x");
        }
        var btnScoreClick= findViewById<Button>(R.id.btnScore)
        var btnStealClick= findViewById<Button>(R.id.btnSteal)
        var btnResetClick=findViewById<Button>(R.id.btnRest)
        btnScoreClick.setOnClickListener{
            if(x<15){
                x+=1
                updateText()
            }
        }

        btnStealClick.setOnClickListener(){
            if(x>0){
                x-=1
                updateText()
            }
        }

        btnResetClick.setOnClickListener(){
            x=0
            updateText()
        }

    }

    private fun updateText() {
        val numDisplay = findViewById<TextView>(R.id.textScoreDisplay)
        numDisplay.text=x.toString()
        when (x) {
            in 5..9 -> {
                numDisplay.setTextColor(Color.parseColor("blue"))
                mMediaPlayer = MediaPlayer.create(this, R.raw.alarm_clock)
                mMediaPlayer!!.start()
            }
            in 5..15 -> {
                numDisplay.setTextColor(Color.parseColor("green"))
            }
            else -> {
                numDisplay.setTextColor(Color.parseColor("black"))
            }
        }


        Log.i("stag",x.toString())
    }


}