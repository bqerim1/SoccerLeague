package com.example.soccerleague.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.soccerleague.models.Team

class TeamsViewModel : ViewModel() {

    val TAG = "TeamsViewModel"

    /**
     * Method generates 20 unique teams.
      */
    fun generateTeams() : MutableList<Team> {
         val teams: MutableList<Team> = mutableListOf()

        val teamNames = listOf(
            "Real Madrid", "FC Barcelona", "Manchester United", "Bayern Munich", "Liverpool",
            "Juventus", "Paris Saint-Germain", "Chelsea", "Manchester City", "Arsenal",
            "Borussia Dortmund", "AC Milan", "Inter Milan", "Atletico Madrid", "Tottenham Hotspur",
            "AS Roma", "Ajax", "Benfica", "Porto", "Olympique Marseille", "FC Zurich", "Basel", "FC Drita", "Young Boys"
        )

        val logos = listOf(
            "real-madrid.png", "barcelona.png", "manutd.png", "bayern.png", "liverpool.png",
            "juventus.png", "psg.png", "chelsea.png", "mancity.png", "arsenal.png",
            "dortmund.png", "milan.png", "inter.png", "atletico-madrid.png", "totteham.png",
            "roma.png", "ajax.png", "benfica.png", "porto.png", "marseille.png", "zurich.png", "basel.png", "drita.png", "young-boys.png"
        )

        val coaches = listOf(
            "Carlo Ancelotti", "Xavi Hernandez", "Ole Gunnar Solskjaer", "Hans-Dieter Flick", "Jurgen Klopp",
            "Andrea Pirlo", "Mauricio Pochettino", "Thomas Tuchel", "Pep Guardiola", "Mikel Arteta",
            "Edin Terzic", "Stefano Pioli", "Antonio Conte", "Diego Simeone", "Jose Mourinho",
            "Paulo Fonseca", "Erik ten Hag", "Jorge Jesus", "Sergio Conceicao", "Jorge Sampaoli", "Franco Foda", "Heiko Vogel", "Ismet Munishi", "Raphael Wicky"
        )

        val cities = listOf(
            "Madrid", "Barcelona", "Manchester", "Munich", "Liverpool",
            "Turin", "Paris", "London", "Manchester", "London",
            "Dortmund", "Milan", "Milan", "Madrid", "London",
            "Rome", "Amsterdam", "Lisbon", "Porto", "Marseille", "Zurich", "Basel", "Gjilan", "Bern"
        )

        val shuffledIndices = (teamNames.indices).shuffled()

        for (i in 0 until 20) {
            val index = shuffledIndices[i]
            val team = Team(
                name = teamNames[index],
                logoUrl = logos[index],
                coachName = coaches[index],
                city = cities[index]
            )
            teams.add(team)
        }

        Log.d(TAG,"$teams")
        return teams
    }

}



