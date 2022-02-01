package com.example.rps_20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rps_20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RPSView {

    private var rock: String = "Rock"
    private var paper: String = "Paper"
    private var scissors: String = "Scissors"

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: RPSPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = RPSPresenter(this)
        presenter.start()
    }

    override fun onRockPressed() = with(binding) {
        butRock.setOnClickListener {
            presenter.makePlayerChoise(rock)
        }
    }

    override fun onPaperPressed() = with(binding) {
        butPaper.setOnClickListener {
            presenter.makePlayerChoise(paper)
        }
    }

    override fun onScissorsPressed() = with(binding) {
        butScissors.setOnClickListener {
            presenter.makePlayerChoise(scissors)
        }
    }

    override fun onGamePressed() = with(binding) {
        butGame.setOnClickListener {
            presenter.onGameClicked()
        }
    }

    override fun onNewGamePressed() = with(binding) {
        butNewGame.setOnClickListener {
            presenter.makeNewGame()
        }
    }

    override fun showPlayerScore(score: Int?) = with(binding) {
        playerScore.text = score.toString()
    }

    override fun showAIScore(score: Int?) = with(binding) {
        AIScore.text = score.toString()
    }

    override fun showPlayerChoice(result: String?) = with(binding) {
        textPlayerChoice.text = result
    }

    override fun showAIChoice(result: String?) = with(binding) {
        textAIChoice.text = result
    }

    override fun showWinner(result: String?): Unit = with(binding) {
        textWinner.text = result
    }
}
