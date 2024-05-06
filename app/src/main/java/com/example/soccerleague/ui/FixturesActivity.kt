package com.example.soccerleague.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soccerleague.Constants.RESULT_LIST_EXTRA
import com.example.soccerleague.Constants.TEAM_LIST_EXTRA
import com.example.soccerleague.adapter.FixtureAdapter
import com.example.soccerleague.databinding.ActivityFixturesBinding
import com.example.soccerleague.models.Fixture
import com.example.soccerleague.models.Team
import com.example.soccerleague.viewModel.FixtureViewModel

class FixturesActivity : AppCompatActivity() {

    private val TAG = "FixturesActivity"
    private lateinit var fixturesBinding: ActivityFixturesBinding
    private val fixtureViewModel: FixtureViewModel by lazy {
        ViewModelProvider(this)[FixtureViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fixturesBinding = ActivityFixturesBinding.inflate(layoutInflater)
        setContentView(fixturesBinding.root)
        val teamsList = intent.getSerializableExtra(TEAM_LIST_EXTRA) as ArrayList<Team>
        val fixtures = fixtureViewModel.generateFixturesAndSimulateMatches(teamsList)
        fixturesBinding.fixturesRecyclerView.layoutManager = LinearLayoutManager(this)
        Log.d(TAG, "teamsList: $teamsList")

        Log.d(TAG, "fixtures: $fixtures")

        val adapter = FixtureAdapter(fixtures)
        fixturesBinding.fixturesRecyclerView.adapter = adapter

        fixturesBinding.standingBtn.setOnClickListener {
            goToStandingView(fixtures)
        }

    }

    private fun goToStandingView(fixturesList: List<Fixture>) {
        val intent = Intent(this, StandingActivity::class.java)
        intent.putExtra(RESULT_LIST_EXTRA, ArrayList(fixturesList))
        startActivity(intent)
    }
}

