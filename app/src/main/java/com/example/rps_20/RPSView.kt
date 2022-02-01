package com.example.rps_20

interface RPSView {

    fun onRockPressed()
    fun onPaperPressed()
    fun onScissorsPressed()

    fun onGamePressed()
    fun onNewGamePressed()

    fun showPlayerScore(score: Int?)
    fun showAIScore(score: Int?)

    fun showPlayerChoice(result: String?)
    fun showAIChoice(result: String?)

    fun showWinner(result: String?)

}