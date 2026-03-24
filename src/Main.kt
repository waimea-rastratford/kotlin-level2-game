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
val player1Name = String
val player2Name = String

fun main() {

    createBoard()
    addCounters()
    showBoard()
    getPlayerNames()


    while (true) {

    val action = getPlayer1Action()

    when (action) {



    }

    }



}


fun createBoard() {

    while (board.size < boardSize) {
        board.add(" ")
    }


}

fun addCounters() {
    val whiteCounter = "□".white()
    repeat(4) {
        while (true) {
            val random = (0..15).random()
            if (board[random] == " ") {
                board[random] = whiteCounter
                break
            }
        }
    }

    val blackCounter = "■".red()
    while (true) {
        val random = (0..15).random()
        if (board[random] == " ") {
            board[random] = blackCounter
            break
        }
    }


    }

fun showBoard() {
    println("  1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16 ")
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


fun getPlayerNames() {

    print("Enter Player 1 Name: ")
    val player1Name = readln()

    print("Enter Player 2 Name: ")
    val player2Name = readln()



}



fun getPlayer1Action() {

    print("Choose a counter: ")

    val p1Choice = readln().toInt()

    print("where do you want to move it")


}