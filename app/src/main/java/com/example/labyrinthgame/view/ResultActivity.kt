// src/main/java/com/example/labirynthgame/view/ResultActivity.kt
package com.example.labyrinthgame.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.labyrinthgame.R

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("score", 0)
        val resultText: TextView = findViewById(R.id.resultText)
        resultText.text = "Gratulacje! Twój wynik ruchów to: $score"

        findViewById<Button>(R.id.restartButton).setOnClickListener {
            restartGame()
        }
    }

    private fun restartGame() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
