package com.example.codechallange_gamesuit.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.codechallange_gamesuit.R
import com.example.codechallange_gamesuit.databinding.ActivityGamePlayerBinding
import kotlin.system.exitProcess

class GameActivityPlayer : AppCompatActivity() {

    private lateinit var bindingGamePlayer: ActivityGamePlayerBinding
    private var playerOneChoose =""
    private var playerTwoChoose =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingGamePlayer = ActivityGamePlayerBinding.inflate(layoutInflater)
        val viewPlayerGame = bindingGamePlayer.root
        setContentView(viewPlayerGame)

        bindingGamePlayer.winnerResults.setText(R.string.txt_blank)
        bindingGamePlayer.btnTryagain.visibility = View.GONE



        fun kunciPilihanSatu() {
            bindingGamePlayer.playeronerockchoose.isClickable = false
            bindingGamePlayer.playeronepaperchoose.isClickable = false
            bindingGamePlayer.playeronescissorschoose.isClickable = false
//            bindingGamePlayer.playeronerockchoose.setBackgroundResource(R.drawable.bg_transparan)
//            bindingGamePlayer.playeronepaperchoose.setBackgroundResource(R.drawable.bg_transparan)
//            bindingGamePlayer.playeronescissorschoose.setBackgroundResource(R.drawable.bg_transparan)
        }

        fun kunciPilihanDua() {
            bindingGamePlayer.playerTwoRockChoose.isClickable = false
            bindingGamePlayer.playerTwoPaperChoose.isClickable = false
            bindingGamePlayer.playerTwoScissorsChoose.isClickable = false
//            bindingGamePlayer.playerTwoRockChoose.setBackgroundResource(R.drawable.bg_transparan)
//            bindingGamePlayer.playerTwoPaperChoose.setBackgroundResource(R.drawable.bg_transparan)
//            bindingGamePlayer.playerTwoScissorsChoose.setBackgroundResource(R.drawable.bg_transparan)
        }
        fun result() {
            if(playerOneChoose == "rock" && playerTwoChoose == "batu") {
                bindingGamePlayer.winnerResults.setText(R.string.txt_draw)
                bindingGamePlayer.btnTryagain.visibility = View.VISIBLE
                Log.d("Results", "Draw")
            } else if( playerOneChoose == "rock" && playerTwoChoose == "paper"){
                bindingGamePlayer.winnerResults.setText(R.string.player_two_win)
                bindingGamePlayer.btnTryagain.visibility = View.VISIBLE
                Log.d("Results", "Player 2 Win")
            } else if (playerOneChoose == "rock" && playerTwoChoose == "scissors") {
                bindingGamePlayer.winnerResults.setText(R.string.player_one_win)
                bindingGamePlayer.btnTryagain.visibility = View.VISIBLE
                Log.d("Results", "Player 1 Win")

            } else if (playerOneChoose == "paper" && playerTwoChoose == "rock") {
                bindingGamePlayer.winnerResults.setText(R.string.player_one_win)
                bindingGamePlayer.btnTryagain.visibility = View.VISIBLE
                Log.d("Results", "Player 1 Win")

            } else if (playerOneChoose == "paper" && playerTwoChoose == "paper") {
                bindingGamePlayer.winnerResults.setText(R.string.txt_draw)
                bindingGamePlayer.btnTryagain.visibility = View.VISIBLE
                Log.d("Results", "Draw")

            } else if (playerOneChoose == "paper" && playerTwoChoose == "scissors") {
                bindingGamePlayer.winnerResults.setText(R.string.player_two_win)
                bindingGamePlayer.btnTryagain.visibility = View.VISIBLE
                Log.d("Results", "Player 2 Win")

            } else if (playerOneChoose == "scissors" && playerTwoChoose == "rock") {
                bindingGamePlayer.winnerResults.setText(R.string.player_two_win)
                bindingGamePlayer.btnTryagain.visibility = View.VISIBLE
                Log.d("Results", "Player 2 Win")

            } else if (playerOneChoose == "scissors" && playerTwoChoose == "paper") {
                bindingGamePlayer.winnerResults.setText(R.string.player_one_win)
                bindingGamePlayer.btnTryagain.visibility = View.VISIBLE
                Log.d("Results", "Player 1 Win")

            } else if (playerOneChoose == "scissors" && playerTwoChoose == "scissors") {
                bindingGamePlayer.winnerResults.setText(R.string.txt_draw)
                bindingGamePlayer.btnTryagain.visibility = View.VISIBLE
                Log.d("Results", "Draw")
            }
        }

        fun playerTwoTurn(){
            bindingGamePlayer.playerTwoRockChoose.setOnClickListener {
                playerTwoChoose = "rock"
                bindingGamePlayer.playerTwoRockChoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
                Log.d("PlayerTwo", playerTwoChoose)
                result()
                kunciPilihanDua()
            }
            bindingGamePlayer.playerTwoPaperChoose.setOnClickListener {
                playerTwoChoose = "paper"
                bindingGamePlayer.playerTwoPaperChoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
                Log.d("PlayerTwo", playerTwoChoose)
                result()
                kunciPilihanDua()
            }
            bindingGamePlayer.playerTwoScissorsChoose.setOnClickListener {
                playerTwoChoose = "scissors"
                bindingGamePlayer.playerTwoScissorsChoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
                Log.d("PlayerTwo", playerTwoChoose)
                result()
                kunciPilihanDua()
            }
        }

        //here code for player one choose
        bindingGamePlayer.playeronerockchoose.setOnClickListener {
            playerOneChoose = "rock"
            bindingGamePlayer.playeronerockchoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
            Log.d("PlayerOne", playerOneChoose)
            kunciPilihanSatu()
            playerTwoTurn()

        }
        bindingGamePlayer.playeronepaperchoose.setOnClickListener {
            playerOneChoose = "paper"
            bindingGamePlayer.playeronepaperchoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
            Log.d("PlayerOne", playerOneChoose)
            kunciPilihanSatu()
            playerTwoTurn()

        }
        bindingGamePlayer.playeronescissorschoose.setOnClickListener {
            playerOneChoose = "scissors"
            bindingGamePlayer.playeronescissorschoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
            Log.d("PlayerOne", playerOneChoose)
            kunciPilihanSatu()
            playerTwoTurn()

        }


        //here code for player two choose

        //here for try game again
        bindingGamePlayer.btnTryagain.setOnClickListener {
            bindingGamePlayer.playeronerockchoose.isClickable = true
            bindingGamePlayer.playeronepaperchoose.isClickable = true
            bindingGamePlayer.playeronescissorschoose.isClickable = true
            bindingGamePlayer.winnerResults.setText(R.string.txt_blank)

            bindingGamePlayer.playeronerockchoose.setBackgroundColor(Color.parseColor("#FFFFFF"))
            bindingGamePlayer.playeronepaperchoose.setBackgroundColor(Color.parseColor("#FFFFFF"))
            bindingGamePlayer.playeronescissorschoose.setBackgroundColor(Color.parseColor("#FFFFFF"))

            bindingGamePlayer.playerTwoRockChoose.setBackgroundColor(Color.parseColor("#FFFFFF"))
            bindingGamePlayer.playerTwoPaperChoose.setBackgroundColor(Color.parseColor("#FFFFFF"))
            bindingGamePlayer.playerTwoScissorsChoose.setBackgroundColor(Color.parseColor("#FFFFFF"))

            bindingGamePlayer.btnTryagain.visibility = View.GONE
        }

        //here for the home and exit button
        bindingGamePlayer.btnBack.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
        bindingGamePlayer.btnCloseApps.setOnClickListener {
            moveTaskToBack(true)
            exitProcess(1)
        }
    }

}