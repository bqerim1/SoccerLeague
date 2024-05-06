package com.example.soccerleague.models

import java.io.Serializable

data class Fixture(
    val homeTeam: Team,
    val awayTeam: Team,
    var homeGoals: Int = 0,
    var awayGoals: Int = 0
):Serializable
