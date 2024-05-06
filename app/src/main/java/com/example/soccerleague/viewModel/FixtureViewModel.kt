package com.example.soccerleague.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.soccerleague.models.Fixture
import com.example.soccerleague.models.Team
import kotlin.random.Random

class FixtureViewModel : ViewModel() {
    private var TAG = "FixtureViewModel"
    private val fixtures: MutableList<Fixture> = mutableListOf()

    /**
     * Generate fixtures and simulate matches
     */
    fun generateFixturesAndSimulateMatches(teams: MutableList<Team>):  MutableList<Fixture> {
        generateFixtures(teams)
        simulateMatches()

        return fixtures
    }


    /**
     *This function is responsible for generating match fixtures for a soccer league
     *  based on the provided list of teams.
     *  It pairs each team with all the other teams in the league to create
     *  home and away fixtures. The generated fixtures are stored in a list and
     *  shuffled to randomize the match schedule.
     */
    private fun generateFixtures(teams: MutableList<Team>) {
        Log.d(TAG,"inside generateFixtures $teams")

        val numberOfTeams = teams.size

        for (i in 0 until numberOfTeams - 1) {
            val homeTeam = teams[i]

            for (j in i + 1 until numberOfTeams) {
                val awayTeam = teams[j]

                // Add fixture for home and away game
                fixtures.add(Fixture(homeTeam, awayTeam))
                fixtures.add(Fixture(awayTeam, homeTeam))
            }
        }


        fixtures.shuffle()
    }

    private fun simulateMatches() {
        for (fixture in fixtures) {
            val (homeGoals, awayGoals) = generateRandomGoals()
            fixture.homeGoals = homeGoals
            fixture.awayGoals = awayGoals

            updateTeamPoints(fixture)
        }
        Log.d(TAG,"${fixtures.size}")
    }

    /**
     * Generate auto random goals for both away and home.
     */
    private fun generateRandomGoals(): Pair<Int, Int> {
        val homeGoals = Random.nextInt(0, 5)
        val awayGoals = Random.nextInt(0, 5)
        return Pair(homeGoals, awayGoals)
    }


    /**
     * Upate team point baased on home goals
     */
    private fun updateTeamPoints(fixture: Fixture) {
        val homeGoals = fixture.homeGoals
        val awayGoals = fixture.awayGoals

        if (homeGoals > awayGoals) {
            fixture.homeTeam.points += 3
        } else if (homeGoals < awayGoals) {
            fixture.awayTeam.points += 3
        } else {
            fixture.homeTeam.points += 1
            fixture.awayTeam.points += 1
        }
    }


}



