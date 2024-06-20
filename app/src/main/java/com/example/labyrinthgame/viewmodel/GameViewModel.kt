package com.example.labyrinthgame.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.labyrinthgame.model.GameModel

class GameViewModel : ViewModel() {
    private val _gameModel = MutableLiveData<GameModel>()
    val gameModel: LiveData<GameModel> get() = _gameModel

    init {
        _gameModel.value = GameModel(0, 0)
    }

    fun move(direction: String) {
        _gameModel.value = _gameModel.value?.move(direction)
    }

    fun canMove(direction: String): Boolean {
        return _gameModel.value?.canMove(direction) ?: false
    }

    fun isGameEnded(): Boolean {
        return _gameModel.value?.gameEnded ?: false
    }
}
