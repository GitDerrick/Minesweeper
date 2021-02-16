package minesweeper

import kotlin.random.Random

fun initBothFields (mines: Int) {
    var minesRemaining = mines
    for (row in mineField) {  // Build mineField
        for (i in row.indices) row[i] = '.'
    }
    while (minesRemaining > 0) { // Place mines in mineField
        val i = Random.nextInt(9)
        val j = Random.nextInt(9)
        if (mineField[i][j] == '.') {
            mineField[i][j] = 'X'
            minesRemaining --
        }
    }

    for (row in playingField) { // Build playingField
        for (i in row.indices) row[i] = '.'
    }
} // Builds initial mineField w/ mines & blank playingField

fun changeToNumberOrAdd(x: Int, y: Int) {
    if (x !in 0..8 || y !in 0..8) return // Stops if index is out of bounds
    when {
        mineField[x][y] == 'X'-> mineField[x][y]
        mineField[x][y] == '.'-> mineField[x][y] = '1'
        else -> mineField[x][y] = mineField[x][y] + 1
    }
} // Places hints around mine from lookAround

fun lookAround() {
    for (i in mineField.indices) {
        for (j in mineField[i].indices) {
            if (mineField[i][j] == 'X') {
                changeToNumberOrAdd(i - 1, j - 1)
                changeToNumberOrAdd(i - 1, j)
                changeToNumberOrAdd(i - 1, j + 1)
                changeToNumberOrAdd(i, j - 1)
                changeToNumberOrAdd(i, j + 1)
                changeToNumberOrAdd(i + 1, j - 1)
                changeToNumberOrAdd(i + 1, j)
                changeToNumberOrAdd(i + 1, j + 1)
            }
        }
    }
} // Places hints on mineField

fun printPlayingField() {
    println(" |123456789|")
    println("—|—————————|")
    for (i in playingField.indices) {
        print("${i + 1}|")
        for (j in playingField[i].indices) print("${playingField[i][j]}")
        print("|")
        println()
    }
    println("—|—————————|")
}

fun floodFill(x: Int, y: Int) {
    if (x !in 0..8 || y !in 0..8) return // Stops if index is out of bounds
    if (playingField[x][y] == '*' && mineField[x][y] != 'X') playingField[x][y] = '.'
    if (playingField[x][y] != '.') return // go back if pF_pos already changed from '.'
    if (playingField[x][y] == '.' && mineField[x][y] in '1'..'8') {
        playingField[x][y] = mineField[x][y]
        return
    } // change pF_pos to number & don't move on
    playingField[x][y] = '/'
    floodFill(x - 1, y - 1) // Up & left
    floodFill(x, y - 1) // Up
    floodFill(x + 1, y - 1) // Up & right
    floodFill(x - 1, y) // Left
    floodFill(x + 1, y) // Right
    floodFill(x - 1, y + 1) // Down & left
    floodFill(x, y + 1) // Down
    floodFill(x + 1, y + 1) // Down & right
} // doesn't check if 'X'

fun checkIfCompleted(numOfMines: Int): Boolean {
    var minesLeftToBeGuessed = numOfMines
    var exploredCellsCountdown = 9 * 9 - numOfMines

    for (i in playingField.indices) {
        for (j in playingField[i].indices) {
            if (playingField[i][j] == '*' && mineField[i][j] == 'X') minesLeftToBeGuessed --
            if (playingField[i][j] == '*' && mineField[i][j] != 'X') minesLeftToBeGuessed ++
            if (playingField[i][j] == '/' || playingField[i][j] in '1'..'8') exploredCellsCountdown --
        }
    } // checks for correct & incorrect marks on pF & # of remaining explored cells

    return (minesLeftToBeGuessed == 0 || exploredCellsCountdown == 0)
} // All cells explored or all mines correctly marked?

fun revealMines() {
    for (i in mineField.indices) {
        for (j in mineField[i].indices) {
            if (mineField[i][j] == 'X') playingField[i][j] = 'X'
        }
    }
} // places mines on pF

var mineField = Array(9) {CharArray(9)} // for location of mines
var playingField = Array(9) {CharArray(9)} // what the player sees
var blownUp = false

fun main() {
    print("How many mines do you want on the field? > ")
    val numOfMines = readLine()!!.toInt()

    initBothFields(numOfMines)
    lookAround()
    printPlayingField()

    while (!checkIfCompleted(numOfMines) && !blownUp) {
        print("Set/unset mines marks or claim a cell as free: > ")
        val (a, b, arg) = readLine()!!.split(' ')
        val x = b.toInt() - 1
        val y = a.toInt() - 1

        when {
            arg == "mine" -> {
                when {
                    playingField[x][y] in '1'..'8' -> return
                    playingField[x][y] != '.' -> playingField[x][y] = '.'
                    else -> playingField[x][y] = '*'
                }
            }
            mineField[x][y] == 'X' -> {
                blownUp = true
                revealMines()
            }
            else -> {
                floodFill(x, y)
            }
        }

        printPlayingField()
    }

    if (blownUp) println("You stepped on a mine and failed!") else
    println("Congratulations! You found all the mines!")
}