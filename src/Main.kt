/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Pinned
 * Project Author: Ryan Stratford
 * GitHub Repo:    GITHUB REPO URL HERE
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */


val board = mutableListOf<String>()
var boardSize = 16
var player1Name = ""
var player2Name = ""
val whiteCounter = "■".white()
val blackCounter = "■".red()

fun main() {

    createBoard()
    addCounters()
    showBoard()
    getPlayerNames()


    while (true) {

    val action = getPlayer1Action()


    }



}


fun createBoard() {

    while (board.size < boardSize) {
        board.add(" ")
    }


}

fun addCounters() {
    repeat(4) {
        while (true) {
            val random = (1..15).random()
            if (board[random] == " ") {
                board[random] = whiteCounter
                break
            }
        }
    }

    while (true) {
        val random = (1..15).random()
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
    player1Name = readln()

    print("Enter Player 2 Name: ")
    player2Name = readln()


}



fun getPlayer1Action() {
    var p1MoveToIndex = 0

    while (true) {
    print("$player1Name Choose a counter: ")

    val p1CounterIndex = readln().toInt() - 1

        print("where do you want to move it:  ")
        println()
        println()
        p1MoveToIndex = readln().toInt() - 1
        if (p1MoveToIndex >= p1CounterIndex) {
            println("Invalid move ".bold().red())
            println()
            continue

        }

        // loop from move index up to counter index
        // CHeck if any counters in way


        var counterCount = 0
        for (i in p1MoveToIndex..<p1CounterIndex) {
            if (board[i] == whiteCounter || board[i] == blackCounter) {
                counterCount++
            }
        }



        if (counterCount > 0) {
            println()
            println("Invalid move".bold().red())
            println()
        }
        else{
            val choice1 = board[p1CounterIndex]
            val choice2 = board[p1MoveToIndex]

            board[p1MoveToIndex] = choice1
            board[p1CounterIndex] = choice2


        }

        showBoard()
    break

    }

    getPlayer2Action()
}



fun getPlayer2Action() {
    var p2MoveToIndex = 0

    while (true) {
        print("$player2Name Choose a counter: ")

        val p2CounterIndex = readln().toInt() - 1

        print("where do you want to move it:  ")
        println()
        println()
        p2MoveToIndex = readln().toInt() - 1
        if (p2MoveToIndex >= p2CounterIndex) {
            println("Invalid move ".bold().red())
            println()
            continue

        }

        // loop from move index up to counter index
        // CHeck if any counters in way

        println()
        var counterCount = 0
        for (i in p2MoveToIndex..<p2CounterIndex) {
            if (board[i] == whiteCounter || board[i] == blackCounter) {
                counterCount++
            }
        }



        if (counterCount > 0) {
            println()
            println("Invalid move".bold().red())
            println()
        }
        else{
            val choice1 = board[p2CounterIndex]
            val choice2 = board[p2MoveToIndex]

            board[p2MoveToIndex] = choice1
            board[p2CounterIndex] = choice2


        }

        showBoard()
        break

    }

    getPlayer1Action()
}