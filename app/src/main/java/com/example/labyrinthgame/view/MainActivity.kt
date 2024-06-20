// src/main/java/com/example/labirynthgame/view/MainActivity.kt
package com.example.labyrinthgame.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.labyrinthgame.R
import com.example.labyrinthgame.viewmodel.GameViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        findViewById<Button>(R.id.startButton).setOnClickListener {
            startGame()
        }
    }

    private fun startGame() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}
