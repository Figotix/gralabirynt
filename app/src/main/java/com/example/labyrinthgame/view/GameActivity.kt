// src/main/java/com/example/labirynthgame/view/GameActivity.kt
package com.example.labyrinthgame.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.labyrinthgame.R
import com.example.labyrinthgame.viewmodel.GameViewModel

class GameActivity : AppCompatActivity() {

    private lateinit var viewModel: GameViewModel
    private lateinit var roomText: TextView
    private lateinit var buttonUp: Button
    private lateinit var buttonLeft: Button
    private lateinit var buttonRight: Button
    private lateinit var buttonDown: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        initViewModel()
        initViewBindings()
        observeViewModel()
        setButtonListeners()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
    }

    private fun initViewBindings() {
        roomText = findViewById(R.id.roomText)
        buttonUp = findViewById(R.id.buttonUp)
        buttonLeft = findViewById(R.id.buttonLeft)
        buttonRight = findViewById(R.id.buttonRight)
        buttonDown = findViewById(R.id.buttonDown)
    }

    private fun observeViewModel() {
        viewModel.gameModel.observe(this, Observer { gameModel ->
            roomText.text = "Pokój ${gameModel.currentRoom}"
            updateButtons()
            if (viewModel.isGameEnded()) {
                endGame()
            }
        })
    }

    private fun setButtonListeners() {
        buttonUp.setOnClickListener { viewModel.move("up") }
        buttonLeft.setOnClickListener { viewModel.move("left") }
        buttonRight.setOnClickListener { viewModel.move("right") }
        buttonDown.setOnClickListener { viewModel.move("down") }
    }

    private fun updateButtons() {
        buttonUp.isEnabled = viewModel.canMove("up")
        buttonLeft.isEnabled = viewModel.canMove("left")
        buttonRight.isEnabled = viewModel.canMove("right")
        buttonDown.isEnabled = viewModel.canMove("down")

        setButtonState(buttonUp, viewModel.canMove("up"))
        setButtonState(buttonLeft, viewModel.canMove("left"))
        setButtonState(buttonRight, viewModel.canMove("right"))
        setButtonState(buttonDown, viewModel.canMove("down"))
    }

    private fun setButtonState(button: Button, enabled: Boolean) {
        button.isEnabled = enabled
        val color = if (enabled) R.color.button_enabled else R.color.button_disabled
        button.setBackgroundColor(ContextCompat.getColor(this, color))
    }

    private fun endGame() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("score", viewModel.gameModel.value?.score)
        startActivity(intent)
        finish()
    }
}
