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
val emptySlot = " "
var boardSize = 16
var player1Name = ""
var player2Name = ""
val whiteCounter = "■".white()
val blackCounter = "■".red()
var gameCounter = 0

fun main() {

    showInstructions()
    createBoard()
    addCounters()
    showBoard()
    getPlayerNames()
    // main game loop

    while (true) {

        getPlayer1Action()


    }



}



fun showInstructions() {
    println("------------------------------------------------------------------------------------------------------------------------------------------------------------------".blue())
    print("# Pinned \uD83D\uDCCC\n".blue() +
            "\n" +
            "### Game Setup\n".blue() +
            "- A row of 16 squares, numbered 1 to 16 from left to right\n".blue() +
            "- 5 counters (total) are placed randomly on the board - 4 white and 1 black \n".blue() +
            "- Decide who goes first\n".blue() +
            "\n" +
            "### Gameplay\n".blue() +
            "- Players take turns - You may not skip your turn\n".blue() +
            "- On your turn you must do exactly one of the following:\n".blue() +
            "    - Slide any counter (black or white) any number of squares to the left, as long as no other counter is in the way and the destination square is empty, or... \n".blue() +
            "    - Remove the counter on square 1 (only if a counter is there)\n".blue() +
            "\n" +
            "### Win Condition\n".blue() +
            "- The player who removes the black counter from square 1 wins\n".blue() +
            "\n" +
            "### Variant\n".blue() +
            "- Counters can slide either left or right (but still can't jump other counters)\n".blue())
    println("------------------------------------------------------------------------------------------------------------------------------------------------------------------".blue())

}
fun createBoard() {

    while (board.size < boardSize) {
        board.add(emptySlot)
    }
    //loops through making a list to the size of the boardSize variable(16)

}

fun addCounters() {
    repeat(4) {
        while (true) {
            val random = (1..15).random()
            if (board[random] == emptySlot) {
                board[random] = whiteCounter
                break
            }
        }
    }
    // adds 4 counters in a random position in the list

    while (true) {
        val random = (1..15).random()
        if (board[random] == " ") {
            board[random] = blackCounter
            break
        }
    }
    // adds 1 counter in a random position in the list

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

    // Creates the boards layout


}


fun getPlayerNames() {
    if (gameCounter == 0) {
        while (true) {
            print("Enter Player 1 Name: ".blue())
            player1Name = readln().blue()

            if (player1Name.isNotBlank()) break
        }
        while (true) {
            print("Enter Player 2 Name: ".red())
            player2Name = readln().red()

            if (player2Name.isNotBlank()) break
        }
        println()
    }
}


fun getPlayer1Action() {
    var p1MoveToIndex: Int?
    var p1WinCondition = 0
    var p1CounterIndex: Int?
    while (true) {

        while (true) {
            print("$player1Name Choose a counter: ".blue())
            p1CounterIndex = readlnOrNull()?.toIntOrNull()
            if (p1CounterIndex != null) break
        }
        p1CounterIndex = p1CounterIndex!! - 1
        // gets the first counter then minus 1 to fit in the board


        while (true) {
            print("where do you want to move it: ")
            p1MoveToIndex = readlnOrNull()?.toIntOrNull()

            if (p1MoveToIndex != null) break
        }
        p1MoveToIndex = p1MoveToIndex!! - 1

        if (p1MoveToIndex >= p1CounterIndex) {
            println("Invalid move ".bold().red())
            println()
            continue
        }
        // gets the variable for where the counter is moving

        var counterCount = 0
        for (i in p1MoveToIndex..<p1CounterIndex) {
            if (board[i] == whiteCounter || board[i] == blackCounter) {
                counterCount++
            }
          }
        // loop from move index up to counter index
        // Check if any counters in way


        if( board[p1MoveToIndex] == whiteCounter || board[p1MoveToIndex] == blackCounter)
            counterCount ++
        // Checks if where you are moving contains a counter

        if (counterCount > 0) {
            println()
            println("Invalid move".bold().red())
            println()
            showBoard()
            continue
        }
        // Checks if there have been any errors
        else {
            if (p1MoveToIndex == 0) {

                if (board[p1CounterIndex] == blackCounter) {
                    p1WinCondition++
                }
                else {

                    board[p1CounterIndex] = emptySlot
                }
            } else {
                val choice1 = board[p1CounterIndex]
                val choice2 = board[p1MoveToIndex]

                board[p1MoveToIndex] = choice1
                board[p1CounterIndex] = choice2


            }
        }
        // Checks if you picked the first slot
        // Checks whether it was a black or white counter
        // Then if it wasn't the first slot it moves the counter


        showBoard()
    break

    }

    if (p1WinCondition == 0) {
        getPlayer2Action()
    }
    // if the player hasn't won swap to the other players turn

    else{
        p1endGame()
    }
    // if they have won starts the function for their win
}



fun getPlayer2Action() {
    var p2MoveToIndex: Int?
    var p2WinCondition = 0
    var p2CounterIndex: Int?

    while (true) {


        while (true) {
            print("$player2Name Choose a counter: ".red())
             p2CounterIndex = readlnOrNull()?.toIntOrNull()
            if (p2CounterIndex != null) break
        }
        p2CounterIndex = p2CounterIndex!! - 1

        // gets the first counters number, then minus 1 to fit in the board

        while (true) {
            print("where do you want to move it:  ")
            p2MoveToIndex = readlnOrNull()?.toIntOrNull()
            if (p2MoveToIndex != null) break
        }
        p2MoveToIndex = p2MoveToIndex!! - 1
        // gets the variable for where the counter is moving

        if (p2MoveToIndex >= p2CounterIndex) {
            println("Invalid move ".bold().red())
            println()
            continue

        }

        // loop from move index up to counter index
        // Check if any counters in way

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
        else {
            if (p2MoveToIndex == 0) {
                if (board[p2CounterIndex] == blackCounter) {
                    p2WinCondition++
                }
                else {

                    board[p2CounterIndex] = emptySlot
                }
            } else {
                val choice1 = board[p2CounterIndex]
                val choice2 = board[p2MoveToIndex]

                board[p2MoveToIndex] = choice1
                board[p2CounterIndex] = choice2


            }

            // Checks if you picked the first slot
            // Checks whether it was a black or white counter
            // Then if it wasn't the first slot it moves the counter


        }
        showBoard()
        break

    }
    if (p2WinCondition == 0) {
        getPlayer1Action()
    }
    // if the player hasn't won swap to the other players turn

    else{
        p2endGame()
    }
    // if they have won starts the function for their win
}


fun p1endGame() {

    println("Congrats $player1Name you have won!!")

    print("Do You want to play again? Y/N ")
    val playAgain = readln()

    if (playAgain == "Y"){
        gameCounter ++
        clearBoard()
        main()

    }

}


fun p2endGame() {

    println("Congrats $player2Name you have won!!")

    print("Do You want to play again? Y/N ")
    val playAgain = readln()

    if (playAgain == "Y"){
        gameCounter ++
        clearBoard()
        main()

    }
    }

    fun clearBoard() {
        board.clear()
    }