package com.guillevier.practiceandroidstudio.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.guillevier.practiceandroidstudio.R
import com.guillevier.practiceandroidstudio.ui.viewmodels.ScoreViewModel

// FUNCIONAL
class ScoreActivity : ComponentActivity() {
    private val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score_layout)
        displayForTeamA(viewModel.scoreTeamA)
        displayForTeamB(viewModel.scoreTeamB)

        // Configura el click del botón de reset.
        val resetButton = findViewById<Button>(R.id.reset_button) // Id del btn de reset.
        resetButton.setOnClickListener {
            resetScore()
        }
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    fun addOneForTeamA(v: View?) {
        viewModel.scoreTeamA += 1
        displayForTeamA(viewModel.scoreTeamA)
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    fun addTwoForTeamA(v: View?) {
        viewModel.scoreTeamA += 2
        displayForTeamA(viewModel.scoreTeamA)
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    fun addThreeForTeamA(v: View?) {
        viewModel.scoreTeamA += 3
        displayForTeamA(viewModel.scoreTeamA)
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    fun addOneForTeamB(v: View?) {
        viewModel.scoreTeamB += 1
        displayForTeamB(viewModel.scoreTeamB)
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    fun addTwoForTeamB(v: View?) {
        viewModel.scoreTeamB += 2
        displayForTeamB(viewModel.scoreTeamB)
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    fun addThreeForTeamB(v: View?) {
        viewModel.scoreTeamB += 3
        displayForTeamB(viewModel.scoreTeamB)
    }

    /**
     * Resets the score for both teams back to 0.
     */
    private fun resetScore() {
        viewModel.scoreTeamA = 0
        viewModel.scoreTeamB = 0
        displayForTeamA(viewModel.scoreTeamA)
        displayForTeamB(viewModel.scoreTeamB)
    }

    /**
     * Displays the given score for Team A.
     */
    private fun displayForTeamA(score: Int) {
        val scoreView = findViewById<View>(R.id.team_a_score) as TextView
        scoreView.text = score.toString()
    }

    /**
     * Displays the given score for Team B.
     */
    private fun displayForTeamB(score: Int) {
        val scoreView = findViewById<View>(R.id.team_b_score) as TextView
        scoreView.text = score.toString()
    }
}