package com.example.holakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    // El text to speech sirve para convertir un texto en audio.
    // Hay que implementar la interfaz y en on init indicar que se debe hacer en cada caso
    var tts : TextToSpeech?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tts = TextToSpeech(this,this)
        findViewById<Button>(R.id.btn1).setOnClickListener{speak()}
    }

    private fun speak(){
        var message: String = findViewById<TextView>(R.id.tvHola).text.toString()
        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH,null,"")

    }

    override fun onInit(status: Int) {
if(status == TextToSpeech.SUCCESS){
    findViewById<TextView>(R.id.tvHola).text = "Hello Kotlin!"
    tts!!.setLanguage(Locale("ES"))
}else{
    findViewById<TextView>(R.id.tvHola).text = "No disponible :("


}
    }
}