package com.balqis.basketpoint

import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel(){
    // Deklarasi + inisialisasi
    var scoreTeamA: Int = 0
    var scoreTeamB: Int = 0

    fun incrementScoreA(){
        scoreTeamA++
    }

    fun incrementScoreB(){
        scoreTeamB++
    }

    fun resetScore(){
        scoreTeamA = 0
        scoreTeamB = 0
    }
}