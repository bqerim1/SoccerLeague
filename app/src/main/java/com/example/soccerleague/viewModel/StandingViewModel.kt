package com.example.soccerleague.viewModel

import androidx.lifecycle.ViewModel
import com.example.soccerleague.models.Fixture
import com.example.soccerleague.models.Team

class StandingViewModel : ViewModel() {

    /**
     * This function calculates the points earned by each team in
     * the soccer league based on the provided list of match fixtures.
     * It iterates over each fixture in the list and updates the points
     * for the home and away teams accordingly. After processing all the fixtures,
     * it returns a list of teams with their updated points.
     */
    fun calculatePointsForTeams(fixtures: List<Fixture>): List<Team> {
        val teamPointsMap = mutableMapOf<Team, Int>()

        for (fixture in fixtures) {
            val homeTeamPoints = teamPointsMap.getOrPut(fixture.homeTeam) { 0 }
            teamPointsMap[fixture.homeTeam] = homeTeamPoints + fixture.homeGoals

            val awayTeamPoints = teamPointsMap.getOrPut(fixture.awayTeam) { 0 }
            teamPointsMap[fixture.awayTeam] = awayTeamPoints + fixture.awayGoals
        }

        return teamPointsMap.map { (team, points) ->
            team.copy(points = points)
        }
    }

    fun getTeamsOrderedByPoints(teams: List<Team>): List<Team> {
        return teams.sortedByDescending { it.points }
    }
}