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


// Setting the variables that will be used throughout the code (constants)
val board = mutableListOf<String>()
val emptySlot = " "
var boardSize = 16
var player1Name = ""
var player2Name = ""
val whiteCounter = "■".white()
val blackCounter = "■".red()
var gameCounter = 0

fun main() {
// Setting up the game

    showInstructions()
    createBoard()
    addCounters()
    showBoard()
    getPlayerNames()

    while (true) {
        getPlayer1Action()
    }
}


fun showInstructions() {
    // Rules for the game
    println("------------------------------------------------------------------------------------------------------------------------------------------------------------------".blue())
    print(
        "# Pinned \uD83D\uDCCC\n".blue() +
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
                "- Counters can slide either left or right (but still can't jump other counters)\n".blue()
    )
    println("------------------------------------------------------------------------------------------------------------------------------------------------------------------".blue())
}

/**
 * Creates the board to be played on
 */

fun createBoard() {

    while (board.size < boardSize) {
        board.add(emptySlot)
    }

}

/**
 * adds the  4  white counters and 1 black counter in a random position on the board
 *
 */
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

    while (true) {
        val random = (1..15).random()
        if (board[random] == " ") {
            board[random] = blackCounter
            break
        }
    }


}

/**
 * Designs the layout of the board
 */

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

/**
 * asks for player 1 and player 2 name
 * checks for validity
 */
fun getPlayerNames() {
    if (gameCounter == 0) {
        while (true) {
            print("Enter Player 1 Name: ".blue())
            player1Name = readln()

            if (player1Name.isNotBlank()) break
        }
        println()
        while (true) {
            print("Enter Player 2 Name: ".red())
            player2Name = readln()

            if (player2Name.isNotBlank()) break
        }

        println()
    }

    println("Welcome to pinned".bold().green())
    println()
    showBoard()
}


/**
 * This gets P1 action, validates it. makes the move and passes play to P2
 */
fun getPlayer1Action() {
    var p1MoveToIndex: Int?
    var p1WinCondition = 0
    var p1CounterIndex: Int?
    var p1Choice: String?

    // Keep asking P1 for move until valid
    while (true) {

        // Is square 1 occupied? If so, allow P1 to remove it
        if (board[0] == blackCounter || board[0] == whiteCounter) {
            println()
            println("$player1Name Your turn".blue())
            println("[R]emove the 1st Counter")
            println("[M]ove a Counter")
            p1Choice = readlnOrNull()

        } else {
            p1Choice = " "
        }

        // Are they removing?
        if (p1Choice == "R" || p1Choice == "r") {

            // If it was black - Win!
            if (board[0] == blackCounter) {
                p1endGame()
            }

            // Wasn't a win, so over the P2

            board[0] = emptySlot
            showBoard()
            getPlayer2Action()
        } else {

            // We are moving a counter
            while (true) {
                print("$player1Name Choose a counter: ".blue())
                p1CounterIndex = readlnOrNull()?.toIntOrNull()
                if (p1CounterIndex != null) break
            }
            p1CounterIndex = p1CounterIndex!! - 1


            // keeps asking the player for an answer
            while (true) {
                print("where do you want to move it: ")
                p1MoveToIndex = readlnOrNull()?.toIntOrNull()

                if (p1MoveToIndex != null) break
            }
            p1MoveToIndex = p1MoveToIndex!! - 1

            // Can't move to the right
            if (p1MoveToIndex >= p1CounterIndex) {
                println("Invalid move ".bold().red())
                println()
                continue
            }

            // Check if any counters in way
            var counterCount = 0
            for (i in p1MoveToIndex..<p1CounterIndex) {
                if (board[i] == whiteCounter || board[i] == blackCounter) {
                    counterCount++
                }
            }


            if (board[p1CounterIndex] == emptySlot)
                counterCount++

            if (board[p1MoveToIndex] == whiteCounter || board[p1MoveToIndex] == blackCounter)
                counterCount++


            // checks if move contained an error
            if (counterCount > 0) {
                println()
                println("Invalid move".bold().red())
                println()
                showBoard()
                continue
            } else {

                val choice1 = board[p1CounterIndex]
                val choice2 = board[p1MoveToIndex]

                board[p1MoveToIndex] = choice1
                board[p1CounterIndex] = choice2

            }
        }
        // swaps to other player
        showBoard()
        getPlayer2Action()
    }
}

/**
 * Check player 1 comments
 */
fun getPlayer2Action() {
    var p2MoveToIndex: Int?
    var p2WinCondition = 0
    var p2CounterIndex: Int?
    var p2Choice: String?
    while (true) {


        if (board[0] == blackCounter || board[0] == whiteCounter) {
            println()
            println("$player2Name Your turn".red())
            println("[R]emove the 1st Counter")
            println("[M]ove a Counter")
            p2Choice = readlnOrNull()

        } else {
            p2Choice = " "
        }

        if (p2Choice == "R" || p2Choice == "r") {

            if (board[0] == blackCounter) {
                p2endGame()
            }

            board[0] = emptySlot
            showBoard()
            getPlayer1Action()
        } else {


            while (true) {
                print("$player2Name Choose a counter: ".red())
                p2CounterIndex = readlnOrNull()?.toIntOrNull()
                if (p2CounterIndex != null) break
            }
            p2CounterIndex = p2CounterIndex!! - 1


            while (true) {
                print("where do you want to move it: ")
                p2MoveToIndex = readlnOrNull()?.toIntOrNull()

                if (p2MoveToIndex != null) break
            }
            p2MoveToIndex = p2MoveToIndex!! - 1

            if (p2MoveToIndex >= p2CounterIndex) {
                println("Invalid move ".bold().red())
                println()
                continue
            }

            var counterCount = 0
            for (i in p2MoveToIndex..<p2CounterIndex) {
                if (board[i] == whiteCounter || board[i] == blackCounter) {
                    counterCount++
                }
            }


            if (board[p2MoveToIndex] == whiteCounter || board[p2MoveToIndex] == blackCounter)
                counterCount++


            if (counterCount > 0) {
                println()
                println("Invalid move".bold().red())
                println()
                showBoard()
                continue
            } else {

                val choice1 = board[p2CounterIndex]
                val choice2 = board[p2MoveToIndex]

                board[p2MoveToIndex] = choice1
                board[p2CounterIndex] = choice2

            }
        }


        showBoard()
        getPlayer1Action()
    }
}

/**
 * Ends the game for p1 and asks if they want to replay the game
 */
fun p1endGame() {
    println()
    println("Congrats $player1Name you have won!!".green())
    println()
    print("Do You want to play again? Y/N ")
    val playAgain = readln()

    if (playAgain == "Y") {
        gameCounter++
        clearBoard()
        main()

    }
}

/**
 * Ends the game for p1 and asks if they want to replay the game
 */
fun p2endGame() {

    println("Congrats $player2Name you have won!!")

    print("Do You want to play again? Y/N ")
    val playAgain = readln()

    if (playAgain == "Y") {
        gameCounter++
        clearBoard()
        main()

    }

}

/**
 * Reset game
 */
fun clearBoard() {
    board.clear()
    // Clears the board for the replay
}