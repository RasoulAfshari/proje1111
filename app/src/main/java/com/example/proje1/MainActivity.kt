package com.example.proje1

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var myHandler:Handler= Handler()
    private lateinit var seekBar:SeekBar
    private lateinit var mediaplyer:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_play = findViewById<ImageButton>(R.id.btn_play)
        seekBar=findViewById<SeekBar>(R.id.seekBar)
       // mediaplyer= MediaPlayer.create(this,R.raw.bi)
        var isplay:Boolean=false
        seekBar.max=mediaplyer.duration
        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                mediaplyer.seekTo(seekBar.progress)
            }

        })
        mediaplyer.start()
        btn_play.setOnClickListener {
            if(isplay){
                mediaplyer.pause()
                isplay=false
                btn_play.setImageResource(android.R.drawable.ic_media_play)
            }else{
                mediaplyer.start()
                isplay=true
                btn_play.setImageResource(android.R.drawable.ic_media_pause)
                Handler().postDelayed(updater,200)
            }

        }
    }
    val updater:Runnable=object :Runnable{
        override fun run() {
            Toast.makeText(this@MainActivity,"1", Toast.LENGTH_SHORT).show()
            seekBar.progress=mediaplyer.currentPosition
            Handler().postDelayed(this,200)
        }

    }
}