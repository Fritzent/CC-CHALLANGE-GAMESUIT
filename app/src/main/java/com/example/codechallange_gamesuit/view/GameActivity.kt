package com.example.codechallange_gamesuit.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.codechallange_gamesuit.R
import com.example.codechallange_gamesuit.databinding.ActivityGameBinding
import kotlin.system.exitProcess

class GameActivity : AppCompatActivity() {

    private lateinit var bindingGame: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingGame = ActivityGameBinding.inflate(layoutInflater)
        val viewGame = bindingGame.root
        setContentView(viewGame)

        bindingGame.winnerResults.setText(R.string.txt_blank)
        bindingGame.btnTryagain.visibility = View.GONE

        val itemList = listOf("rock","paper","scissors")
        var playerChoose: String
        var computerChoose: String

        bindingGame.playerrockchoose.setOnClickListener {
            playerChoose = "rock"
            Log.d("Player", playerChoose)
            computerChoose = itemList.random()

            bindingGame.playerrockchoose.isClickable = false
            bindingGame.playerrockchoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
            bindingGame.playerpaperchoose.isClickable = false
            bindingGame.playerscissorschoose.isClickable = false
            bindingGame.btnTryagain.visibility = View.VISIBLE

            when (computerChoose) {
                "rock" -> {
                    bindingGame.comRockChoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
                    bindingGame.winnerResults.setText(R.string.txt_draw)
                    Log.d("Results", "Draw")
                }
                "paper" -> {
                    bindingGame.comPaperChoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
                    bindingGame.winnerResults.setText(R.string.txt_com_win)
                    Log.d("Results", "Com Win")
                }
                "scissors" -> {
                    bindingGame.comScissorsChoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
                    bindingGame.winnerResults.setText(R.string.txt_player_win)
                    Log.d("Results", "Player Win")
                }
            }

        }

        bindingGame.playerpaperchoose.setOnClickListener {
            playerChoose = "paper"
            Log.d("Player", playerChoose)
            computerChoose = itemList.random()

            bindingGame.playerpaperchoose.isClickable = false
            bindingGame.playerpaperchoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
            bindingGame.playerrockchoose.isClickable = false
            bindingGame.playerscissorschoose.isClickable = false
            bindingGame.btnTryagain.visibility = View.VISIBLE

            when (computerChoose) {
                "rock" -> {
                    bindingGame.comRockChoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
                    bindingGame.winnerResults.setText(R.string.txt_player_win)
                    Log.d("Results", "Player Win")
                }
                "paper" -> {
                    bindingGame.comPaperChoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
                    bindingGame.winnerResults.setText(R.string.txt_draw)
                    Log.d("Results", "Draw")
                }
                "scissors" -> {
                    bindingGame.comScissorsChoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
                    bindingGame.winnerResults.setText(R.string.txt_com_win)
                    Log.d("Results", "Com Win")
                }
            }

        }

        bindingGame.playerscissorschoose.setOnClickListener {
            playerChoose = "paper"
            Log.d("Player", playerChoose)
            computerChoose = itemList.random()

            bindingGame.playerscissorschoose.isClickable = false
            bindingGame.playerscissorschoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
            bindingGame.playerrockchoose.isClickable = false
            bindingGame.playerpaperchoose.isClickable = false
            bindingGame.btnTryagain.visibility = View.VISIBLE

            when (computerChoose) {
                "rock" -> {
                    bindingGame.comRockChoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
                    bindingGame.winnerResults.setText(R.string.txt_com_win)
                    Log.d("Results", "Com Win")
                }
                "paper" -> {
                    bindingGame.comPaperChoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
                    bindingGame.winnerResults.setText(R.string.txt_player_win)
                    Log.d("Results", "Player Win")
                }
                "scissors" -> {
                    bindingGame.comScissorsChoose.setBackgroundColor(Color.parseColor("#2e2e2e"))
                    bindingGame.winnerResults.setText(R.string.txt_draw)
                    Log.d("Results", "Draw")
                }
            }

        }

        bindingGame.btnTryagain.setOnClickListener {
            bindingGame.playerrockchoose.isClickable = true
            bindingGame.playerpaperchoose.isClickable = true
            bindingGame.playerscissorschoose.isClickable = true
            bindingGame.winnerResults.setText(R.string.txt_blank)

            bindingGame.playerrockchoose.setBackgroundColor(Color.parseColor("#FFFFFF"))
            bindingGame.playerpaperchoose.setBackgroundColor(Color.parseColor("#FFFFFF"))
            bindingGame.playerscissorschoose.setBackgroundColor(Color.parseColor("#FFFFFF"))

            bindingGame.comRockChoose.setBackgroundColor(Color.parseColor("#FFFFFF"))
            bindingGame.comPaperChoose.setBackgroundColor(Color.parseColor("#FFFFFF"))
            bindingGame.comScissorsChoose.setBackgroundColor(Color.parseColor("#FFFFFF"))

            bindingGame.btnTryagain.visibility = View.GONE
        }

        bindingGame.btnBack.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
        bindingGame.btnCloseApps.setOnClickListener {
            moveTaskToBack(true)
            exitProcess(1)
        }
    }
}