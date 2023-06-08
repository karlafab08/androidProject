package com.example.proyectmovil

import MainActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class LoadingActivity : AppCompatActivity() {

    private lateinit var appname: TextView
    private lateinit var lottie: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        appname = findViewById(R.id.appname)
        lottie = findViewById(R.id.lottie)

        appname.animate().translationY(-1200f).setDuration(2700).setStartDelay(0)
        lottie.animate().translationX(0f).setDuration(2000).setStartDelay(2900)

        Handler().postDelayed({
            val intent = Intent(applicationContext, Signup::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}
