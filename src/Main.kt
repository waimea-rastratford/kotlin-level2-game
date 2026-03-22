/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   PROJECT NAME HERE
 * Project Author: PROJECT AUTHOR HERE
 * GitHub Repo:    GITHUB REPO URL HERE
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */


val board = mutableListOf<String>()
var boardSize = 16
val takenSpaces = mutableListOf<Int>()

fun main() {

    createBoard()
    addCounters()
    showBoard()



}


fun createBoard() {

    while (board.size < boardSize) {
        board.add("-")
    }


}

fun addCounters() {
    val blackCounter = "0"

    for (i in 0..4) {

        val random = 1..boardSize
        val randomSpace = random.random()
        board[randomSpace] = blackCounter
        takenSpaces.add(randomSpace)

    }

    val random = 1..boardSize
    if (random in takenSpaces) {
        
    }


/*
    val randomSpace = Int

    while (randomSpace in takenSpaces) {
        val random = 1..boardSize

    }
*/

    val whiteCounter = "X"




}

fun showBoard() {

    print("┌")
    print("───┬".repeat(board.size - 1))
    println("───┐")

    for (space in board) {

        print("│ $space ".padEnd(4))

    }
    println("│")
    print("└")
    print("───┴".repeat(board.size - 1))
    println("───┘")
    println()



}





