package com.example.soccerleague.ui

import android.content.Intent
import com.example.soccerleague.adapter.TeamAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soccerleague.Constants.TEAM_LIST_EXTRA
import com.example.soccerleague.databinding.ActivityMainBinding
import com.example.soccerleague.models.Team
import com.example.soccerleague.viewModel.TeamsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var teamsList: List<Team>? = null
    private val soccerViewModel: TeamsViewModel by lazy {
        ViewModelProvider(this)[TeamsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        teamsList = soccerViewModel.generateTeams()

        val adapter = TeamAdapter(teamsList as MutableList<Team>)
        binding.recyclerView.adapter = adapter
        binding.generateFixturesButton.setOnClickListener {
            goToFixtureView()
        }
    }

    private fun goToFixtureView() {
        val intent = Intent(this, FixturesActivity::class.java)
        intent.putExtra(TEAM_LIST_EXTRA, ArrayList(teamsList))
        startActivity(intent)
    }

}
