package com.example.soccerleague.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerleague.databinding.ItemSoccerBinding
import com.example.soccerleague.models.Team

class TeamAdapter(private var teamList: List<Team>) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {
    private var selectedPosition = -1 // Initially no item is selected

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSoccerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(teamList[position], position == selectedPosition)
    }

    override fun getItemCount(): Int = teamList.size

    inner class ViewHolder(private val binding: ItemSoccerBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(team: Team, isSelected: Boolean) {
            binding.apply {
                teamNameTextView.text = team.name
                pointsTextView.text = team.points.toString()
                if (isSelected) {
                    showTeamDetails(team)
                } else {
                    hideTeamDetails()
                }
            }
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if (selectedPosition != position) {
                    selectedPosition = position
                    notifyDataSetChanged()
                } else {
                    toggleTeamDetailsVisibility()
                }
            }
        }

        private fun showTeamDetails(team: Team) {
            binding.apply {
                logoUrlTextView.text = team.logoUrl
                coachNameTextView.text = team.coachName
                cityTextView.text = team.city
                setViewsVisibility(true)
            }
        }

        private fun hideTeamDetails() {
            binding.apply {
                clearTextViews()
                setViewsVisibility(false)
            }
        }

        private fun clearTextViews() {
            binding.apply {
                logoUrlTextView.text = ""
                coachNameTextView.text = ""
                cityTextView.text = ""
            }
        }

        private fun setViewsVisibility(isVisible: Boolean) {
            val visibility = if (isVisible) View.VISIBLE else View.GONE
            binding.apply {
                logoUrlTextView.visibility = visibility
                coachNameTextView.visibility = visibility
                cityTextView.visibility = visibility
            }
        }

        private fun toggleTeamDetailsVisibility() {
            binding.apply {
                logoUrlTextView.toggleVisibility()
                coachNameTextView.toggleVisibility()
                cityTextView.toggleVisibility()
            }
        }

        private fun TextView.toggleVisibility() {
            visibility = if (visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }

    }

}
