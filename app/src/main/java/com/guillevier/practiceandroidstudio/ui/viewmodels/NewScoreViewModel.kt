package com.guillevier.practiceandroidstudio.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewScoreViewModel: ViewModel() {
    // Tracks the score for Team A
    private val _scoreTeamA = MutableLiveData(0)
    val scoreTeamA: LiveData<Int> get() = _scoreTeamA

    // Tracks the score for Team B
    private val _scoreTeamB = MutableLiveData(0)
    val scoreTeamB: LiveData<Int> get() = _scoreTeamB

    // Function to add points to Team A
    fun addPointsToTeamA(points: Int) {
        _scoreTeamA.value = (_scoreTeamA.value ?: 0) + points
    }

    // Function to add points to Team B
    fun addPointsToTeamB(points: Int) {
        _scoreTeamB.value = (_scoreTeamB.value ?: 0) + points
    }

    // Function to reset scores
    fun resetScores() {
        _scoreTeamA.value = 0
        _scoreTeamB.value = 0
    }
}