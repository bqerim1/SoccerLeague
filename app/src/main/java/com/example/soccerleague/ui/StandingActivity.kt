package com.example.soccerleague.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soccerleague.Constants
import com.example.soccerleague.adapter.StandingAdapter
import com.example.soccerleague.databinding.StandingActivityBinding
import com.example.soccerleague.models.Fixture
import com.example.soccerleague.viewModel.StandingViewModel

class StandingActivity : AppCompatActivity() {

    private lateinit var binding: StandingActivityBinding
    private val standingViewModel: StandingViewModel by lazy {
        ViewModelProvider(this)[StandingViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StandingActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.standingRecyclerView.layoutManager = LinearLayoutManager(this)
        val fixtureList = intent.getSerializableExtra(Constants.RESULT_LIST_EXTRA) as ArrayList<Fixture>
        initAdapter(fixtureList)

    }

    private fun initAdapter(fixtureList: ArrayList<Fixture>) {
        val teamsList = standingViewModel.calculatePointsForTeams(fixtureList)

        for (team in teamsList) {
            team.goalDifference = team.calculateGoalDifference(team, fixtureList)
        }
        val adapter = StandingAdapter(standingViewModel.getTeamsOrderedByPoints(teamsList))
        binding.standingRecyclerView.adapter = adapter
    }
}
