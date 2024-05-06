package com.example.soccerleague.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerleague.databinding.ItemStandingBinding
import com.example.soccerleague.models.Team

class StandingAdapter(private val teams: List<Team>) :
    RecyclerView.Adapter<StandingAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemStandingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(team: Team) {
            binding.apply {
                teamNameTextView.text = team.name
                pointsTextView.text = team.points.toString()
                gdTextView.text = team.goalDifference.toString()
                cityTextView.text = team.city
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingAdapter.ViewHolder {
        val binding = ItemStandingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StandingAdapter.ViewHolder, position: Int) {
        holder.bind(teams[position])
    }

    override fun getItemCount(): Int {
        return teams.size
    }


}
