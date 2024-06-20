package com.example.labyrinthgame.viewmodel

import androidx.lifecycle.Observer
import com.example.labyrinthgame.model.GameModel
import org.junit.Assert.assertEquals
import org.junit.Test

class GameViewModelTest {

    @Test
    fun testInitialState() {
        val viewModel = GameViewModel()
        val observer = Observer<GameModel> {}
        viewModel.gameModel.observeForever(observer)

        assertEquals(0, viewModel.gameModel.value?.currentRoom)
        assertEquals(0, viewModel.gameModel.value?.score)
        assertEquals(false, viewModel.gameModel.value?.gameEnded)
    }

    @Test
    fun testMoveUp() {
        val viewModel = GameViewModel()
        val observer = Observer<GameModel> {}
        viewModel.gameModel.observeForever(observer)

        viewModel.move("up")
        assertEquals(0, viewModel.gameModel.value?.currentRoom) // assuming initial room is 0 and no move up is possible
    }

    @Test
    fun testMoveDown() {
        val viewModel = GameViewModel()
        val observer = Observer<GameModel> {}
        viewModel.gameModel.observeForever(observer)

        viewModel.move("down")
        assertEquals(4, viewModel.gameModel.value?.currentRoom) // assuming initial room is 0 and move down goes to room 4
    }

    @Test
    fun testMoveLeft() {
        val viewModel = GameViewModel()
        val observer = Observer<GameModel> {}
        viewModel.gameModel.observeForever(observer)

        viewModel.move("left")
        assertEquals(0, viewModel.gameModel.value?.currentRoom) // assuming initial room is 0 and no move left is possible
    }

    @Test
    fun testMoveRight() {
        val viewModel = GameViewModel()
        val observer = Observer<GameModel> {}
        viewModel.gameModel.observeForever(observer)

        viewModel.move("right")
        assertEquals(1, viewModel.gameModel.value?.currentRoom) // assuming initial room is 0 and move right goes to room 1
    }

    @Test
    fun testGameEnd() {
        val viewModel = GameViewModel()
        val observer = Observer<GameModel> {}
        viewModel.gameModel.observeForever(observer)

        // Simulate reaching end room
        viewModel.move("down")
        viewModel.move("right")
        viewModel.move("right")
        viewModel.move("up")
        viewModel.move("right")
        viewModel.move("down")
        viewModel.move("right")

        assertEquals(7, viewModel.gameModel.value?.currentRoom)
        assertEquals(true, viewModel.gameModel.value?.gameEnded)
    }
}
