package com.guillevier.practiceandroidstudio.activities

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.guillevier.practiceandroidstudio.ui.viewmodels.NewScoreViewModel
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.guillevier.practiceandroidstudio.R
import android.widget.Button
import android.widget.TextView

// FUNCIONAL
class NewScoreActivityClickListener : ComponentActivity() {
    private val viewModel: NewScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_score_click_listener_layout)

        // Observa los cambios en el puntaje de Team A
        viewModel.scoreTeamA.observe(this, Observer { score ->
            displayForTeamA(score)
        })

        // Observa los cambios en el puntaje de Team B
        viewModel.scoreTeamB.observe(this, Observer { score ->
            displayForTeamB(score)
        })

        // Configura los clics de los botones
        findViewById<Button>(R.id.add_three_for_team_a).setOnClickListener {
            viewModel.addPointsToTeamA(3)
        }
        findViewById<Button>(R.id.add_two_for_team_a).setOnClickListener {
            viewModel.addPointsToTeamA(2)
        }
        findViewById<Button>(R.id.add_one_for_team_a).setOnClickListener {
            viewModel.addPointsToTeamA(1)
        }
        findViewById<Button>(R.id.add_three_for_team_b).setOnClickListener {
            viewModel.addPointsToTeamB(3)
        }
        findViewById<Button>(R.id.add_two_for_team_b).setOnClickListener {
            viewModel.addPointsToTeamB(2)
        }
        findViewById<Button>(R.id.add_one_for_team_b).setOnClickListener {
            viewModel.addPointsToTeamB(1)
        }

        // Configura el clic del botón de reset
        val resetButton = findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener {
            viewModel.resetScores()
        }
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