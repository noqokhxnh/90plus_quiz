package com.noqok.a90plus_quiz.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.noqok.a90plus_quiz.R
import com.noqok.a90plus_quiz.models.Player

class HintAdapter : RecyclerView.Adapter<HintAdapter.HintViewHolder>() {

    private var hints: List<Player> = emptyList()

    fun updateHints(newHints: List<Player>?) {
        this.hints = newHints ?: emptyList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HintViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hint, parent, false)
        return HintViewHolder(view)
    }

    override fun onBindViewHolder(holder: HintViewHolder, position: Int) {
        holder.bind(hints[position])
    }

    override fun getItemCount(): Int = hints.size

    class HintViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val hintNameTextView: TextView = itemView.findViewById(R.id.hintNameTextView)

        fun bind(player: Player) {
            hintNameTextView.text = player.fullName
        }
    }
}
