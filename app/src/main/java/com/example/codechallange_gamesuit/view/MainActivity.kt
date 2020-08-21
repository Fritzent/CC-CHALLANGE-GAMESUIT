package com.example.codechallange_gamesuit.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.codechallange_gamesuit.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val viewMain = bindingMain.root
        setContentView(viewMain)

        val sharedPreferences = getSharedPreferences(LoginActivity.SP_NAMA, Context.MODE_PRIVATE)
        val usernameInSp = sharedPreferences.getString(LoginActivity.FIELD_USERNAME, "sabrina")

        //here to set the username
        bindingMain.txtUsername.text = usernameInSp
        bindingMain.txtUsernameCpu.text = usernameInSp

        //here to handle the game for player vs cpu
        bindingMain.imageTop.setOnClickListener {
            startActivity(Intent(applicationContext, GameActivity::class.java))
        }

        bindingMain.imageTopCpu.setOnClickListener {
            //TODO here code to go to player vs player game
            startActivity(Intent(applicationContext, GameActivityPlayer::class.java))
        }

        bindingMain.ivUserProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

//        if(statusUser == "ONLINE"){
//            onBackPressed()
//        }
    }

    private var doubleBackToExitPressedOnce = false

    companion object {
        const val TIME_BACK_PRESSED: Long = 2000
    }
    override fun onBackPressed() {
        if(doubleBackToExitPressedOnce){
            moveTaskToBack(true)
            exitProcess(1)
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Tekan Lagi untuk Keluar", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, TIME_BACK_PRESSED)
    }
}