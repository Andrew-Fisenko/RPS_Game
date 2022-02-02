package com.example.rps_20

class RPSPresenter(private val view: RPSView) {

    private var playerScore: Int = 0
    private var AIScore: Int = 0

    private var AIChoice: String? = null
    private var playerChoice: String? = null

    private val options = arrayOf("Rock", "Paper", "Scissors")

    fun start() {
        view.onPaperPressed()
        view.onRockPressed()
        view.onScissorsPressed()

        view.onGamePressed()
        view.onNewGamePressed()
    }

    fun makePlayerChoise(choice: String) {
        playerChoice = choice
        view.showPlayerChoice("You choose - $choice")
    }

    fun onGameClicked() {
        AIChoice = getAIChoice(options)
        val result = game(playerChoice, AIChoice)
        view.showWinner(result)
    }

    private fun game(playerChoice: String?, AIChoice: String?): String? {

        if (playerChoice == null)
            return ("Firstly, make your choice!!!")
        else {
            view.showAIChoice("I choose - $AIChoice")
            return if (playerChoice == "Rock" && AIChoice == "Scissors" ||
                playerChoice == "Paper" && AIChoice == "Rock" ||
                playerChoice == "Scissors" && AIChoice == "Paper"
            ) {
                playerScore++
                view.showPlayerScore(playerScore)
                ("You are - winner!!!")
            } else if (playerChoice == AIChoice) {
                ("It's draw... Let's try again!")
            } else {
                AIScore++
                view.showAIScore(AIScore)
                ("You loose!")
            }
        }
    }

    fun makeNewGame() {
        AIChoice = null
        playerChoice = null
        view.showPlayerChoice(" ")
        view.showAIChoice(" ")
        view.showAIScore(0)
        view.showPlayerScore(0)
        view.showWinner("Let's start the Game!")
    }

    private fun getAIChoice(items: Array<String>) = items[(Math.random() * items.size).toInt()]

}