package com.balqis.basketpoint

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Deklarasi + inisialisasi
    var scoreTeamA: Int = 0
    var scoreTeamB: Int = 0

    // Deklarasi
    private lateinit var scoreA: TextView
    private lateinit var scoreB: TextView

    val viewModel :ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //  Deklarasi + insialisasi
        val buttonA1: Button = findViewById(R.id.buttonA1)
        val buttonB1: Button = findViewById(R.id.buttonB1)
        val buttonA2: Button = findViewById(R.id.buttonA2)
        val buttonB2: Button = findViewById(R.id.buttonB2)
        val buttonA3: Button = findViewById(R.id.buttonA3)
        val buttonB3: Button = findViewById(R.id.buttonB3)
        val buttonReset = findViewById<Button>(R.id.buttonReset)

        // Deklarasi
        scoreA = findViewById(R.id.scoreA)
        scoreB = findViewById(R.id.scoreB)

        scoreA.text = viewModel.scoreTeamA.toString()
        scoreB.text = viewModel.scoreTeamB.toString()


        buttonA1.setOnClickListener {
            incrementScoreA()
        }

        buttonA2.setOnClickListener {
            incrementScoreA()
            incrementScoreA()
        }

        buttonA3.setOnClickListener {
            incrementScoreA()
            incrementScoreA()
            incrementScoreA()
        }

        buttonB1.setOnClickListener {
            incrementScoreB()
        }

        buttonB2.setOnClickListener {
            incrementScoreB()
            incrementScoreB()
        }
        buttonB3.setOnClickListener {
            incrementScoreB()
            incrementScoreB()
            incrementScoreB()
        }

        buttonReset.setOnClickListener {
            resetScores()
        }
    }

    fun incrementScoreA(){
        viewModel.incrementScoreA()
        scoreA.text = viewModel.scoreTeamA.toString()
    }

    fun incrementScoreB(){
        viewModel.incrementScoreB()
        scoreB.text = viewModel.scoreTeamB.toString()
    }

    private fun resetScores() {
        viewModel.resetScore()
        scoreA.text = viewModel.scoreTeamA.toString()
        scoreB.text = viewModel.scoreTeamB.toString()
    }
}