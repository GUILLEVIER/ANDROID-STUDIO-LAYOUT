package com.guillevier.practiceandroidstudio.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.guillevier.practiceandroidstudio.R
import com.guillevier.practiceandroidstudio.viewmodel.NewScoreViewModel

// FUNCIONAL
class NewScoreActivity : ComponentActivity() {
    private val viewModel: NewScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_score_layout)

        // Observa los cambios en el puntaje de Team A
        viewModel.scoreTeamA.observe(this, Observer { score ->
            displayForTeamA(score)
        })

        // Observa los cambios en el puntaje de Team B
        viewModel.scoreTeamB.observe(this, Observer { score ->
            displayForTeamB(score)
        })

        // Configura el clic del botón de reset
        val resetButton = findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener {
            viewModel.resetScores()
        }
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    fun newAddOneForTeamA(v: View?) {
        viewModel.addPointsToTeamA(1)
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    fun newAddTwoForTeamA(v: View?) {
        viewModel.addPointsToTeamA(2)
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    fun newAddThreeForTeamA(v: View?) {
        viewModel.addPointsToTeamA(3)
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    fun newAddOneForTeamB(v: View?) {
        viewModel.addPointsToTeamB(1)
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    fun newAddTwoForTeamB(v: View?) {
        viewModel.addPointsToTeamB(2)
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    fun newAddThreeForTeamB(v: View?) {
        viewModel.addPointsToTeamB(3)
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
