package com.guillevier.practiceandroidstudio.ui.viewmodels

import androidx.lifecycle.ViewModel

// FUNCIONAL
class ScoreViewModel: ViewModel() {
    // Tracks the score for Team A
    var scoreTeamA: Int = 0

    // Tracks the score for Team B
    var scoreTeamB: Int = 0
}