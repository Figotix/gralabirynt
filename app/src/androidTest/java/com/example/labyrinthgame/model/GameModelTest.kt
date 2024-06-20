package com.example.labyrinthgame.model

import org.junit.Assert.assertEquals
import org.junit.Test

class GameModelTest {

    @Test
    fun testInitialState() {
        val gameModel = GameModel(0, 0)
        assertEquals(0, gameModel.currentRoom)
        assertEquals(0, gameModel.score)
        assertEquals(false, gameModel.gameEnded)
    }

    @Test
    fun testMoveUp() {
        var gameModel = GameModel(4, 0)
        gameModel = gameModel.move("up")
        assertEquals(0, gameModel.currentRoom)
        assertEquals(1, gameModel.score)
    }

    @Test
    fun testMoveDown() {
        var gameModel = GameModel(0, 0)
        gameModel = gameModel.move("down")
        assertEquals(4, gameModel.currentRoom)
        assertEquals(1, gameModel.score)
    }

    @Test
    fun testMoveLeft() {
        var gameModel = GameModel(1, 0)
        gameModel = gameModel.move("left")
        assertEquals(0, gameModel.currentRoom)
        assertEquals(1, gameModel.score)
    }

    @Test
    fun testMoveRight() {
        var gameModel = GameModel(0, 0)
        gameModel = gameModel.move("right")
        assertEquals(1, gameModel.currentRoom)
        assertEquals(1, gameModel.score)
    }

    @Test
    fun testGameEnd() {
        var gameModel = GameModel(6, 0)
        gameModel = gameModel.move("right")
        assertEquals(7, gameModel.currentRoom)
        assertEquals(1, gameModel.score)
        assertEquals(true, gameModel.gameEnded)
    }

    @Test
    fun testInvalidMove() {
        var gameModel = GameModel(0, 0)
        gameModel = gameModel.move("left")
        assertEquals(0, gameModel.currentRoom)
        assertEquals(0, gameModel.score)
    }
}
