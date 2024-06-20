// src/main/java/com/example/labirynthgame/model/GameModel.kt
package com.example.labyrinthgame.model

data class GameModel(
    val currentRoom: Int,
    val score: Int,
    val gameEnded: Boolean = false
) {
    private val labyrinth = arrayOf(
        intArrayOf(10, 8, 10, 9),
        intArrayOf(28, 1, 0, 12),
        intArrayOf(12, 10, 9, 13),
        intArrayOf(6, 5, 6, 5)
    )
    private val endRoom = 7

    fun move(direction: String): GameModel {
        if (gameEnded) return this

        val (newRoom, validMove) = when (direction) {
            "up" -> moveUp()
            "down" -> moveDown()
            "left" -> moveLeft()
            "right" -> moveRight()
            else -> currentRoom to false
        }

        if (newRoom == endRoom) {
            return copy(currentRoom = newRoom, score = score + 1, gameEnded = true)
        }

        return if (validMove) copy(currentRoom = newRoom, score = score + 1) else this
    }

    private fun moveUp(): Pair<Int, Boolean> {
        val row = currentRoom / 4
        val col = currentRoom % 4
        return if (row > 0 && labyrinth[row][col] and 8 == 0) {
            currentRoom - 4 to true
        } else {
            currentRoom to false
        }
    }

    private fun moveDown(): Pair<Int, Boolean> {
        val row = currentRoom / 4
        val col = currentRoom % 4
        return if (row < 3 && labyrinth[row][col] and 4 == 0) {
            currentRoom + 4 to true
        } else {
            currentRoom to false
        }
    }

    private fun moveLeft(): Pair<Int, Boolean> {
        val row = currentRoom / 4
        val col = currentRoom % 4
        return if (col > 0 && labyrinth[row][col] and 2 == 0) {
            currentRoom - 1 to true
        } else {
            currentRoom to false
        }
    }

    private fun moveRight(): Pair<Int, Boolean> {
        val row = currentRoom / 4
        val col = currentRoom % 4
        return if (col < 3 && labyrinth[row][col] and 1 == 0) {
            currentRoom + 1 to true
        } else {
            currentRoom to false
        }
    }

    fun canMove(direction: String): Boolean {
        return when (direction) {
            "up" -> moveUp().second
            "down" -> moveDown().second
            "left" -> moveLeft().second
            "right" -> moveRight().second
            else -> false
        }
    }
}
