package com.example.soccerleague.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerleague.databinding.ItemFixturesBinding
import com.example.soccerleague.models.Fixture

class FixtureAdapter(private val fixtures: List<Fixture>) :
    RecyclerView.Adapter<FixtureAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemFixturesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(fixture: Fixture) {
            binding.apply {
                homeTeamTextView.text = fixture.homeTeam.name
                homeGoalsTextView.text = fixture.homeGoals.toString()
                awayGoalsTextView.text = fixture.awayGoals.toString()
                awayTeamTextView.text = fixture.awayTeam.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFixturesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(fixtures[position])
    }

    override fun getItemCount(): Int {
        return fixtures.size
    }
}
