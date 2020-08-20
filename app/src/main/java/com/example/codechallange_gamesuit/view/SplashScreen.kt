package com.example.codechallange_gamesuit.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.codechallange_gamesuit.R
import com.example.codechallange_gamesuit.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    private lateinit var bindingSplash: ActivitySplashScreenBinding

    companion object{
        private const val SPLASH_TIME: Long =6000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSplash = ActivitySplashScreenBinding.inflate(layoutInflater)
        val viewSplash = bindingSplash.root
        setContentView(viewSplash)

        setupAnimationSplash()

        Handler().postDelayed({
            startActivity(Intent(this,OnBoardScreen::class.java))
            finish()
        }, SPLASH_TIME)
    }

    private fun setupAnimationSplash() {
        val animeFadeIn: Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in_anim)

        bindingSplash.splashIvOne.startAnimation(animeFadeIn)
        bindingSplash.splashIvTwo.startAnimation(animeFadeIn)
        bindingSplash.splashTv.startAnimation(animeFadeIn)
    }

}