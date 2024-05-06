package com.example.soccerleague.models

import java.io.Serializable

data class Team(
    val name: String,
    var points: Int = 0,
    val logoUrl: String,
    val coachName: String,
    val city: String,
    var goalDifference: Int = 0
) : Serializable {
    fun calculateGoalDifference(team: Team, fixtures: List<Fixture>): Int {
        var goalDifference = 0

        for (fixture in fixtures) {
            if (fixture.homeTeam.name == team.name) {
                goalDifference += fixture.homeGoals - fixture.awayGoals
            } else if (fixture.awayTeam.name == team.name) {
                goalDifference += fixture.awayGoals - fixture.homeGoals
            }
        }

        return goalDifference
    }
}