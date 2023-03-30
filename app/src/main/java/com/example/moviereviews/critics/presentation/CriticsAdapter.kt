package com.example.moviereviews.critics.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviereviews.critics.domain.model.Critic
import com.example.moviereviews.databinding.ItemCriticsBinding
import javax.inject.Inject

class CriticsAdapter @Inject constructor() :
    PagingDataAdapter<Critic, CriticsAdapter.CriticViewHolder>(DiffCallback) {
    var criticClickListener: CriticClickListener? = null

    companion object DiffCallback : DiffUtil.ItemCallback<Critic>() {
        override fun areItemsTheSame(oldItem: Critic, newItem: Critic): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Critic, newItem: Critic): Boolean {
            return oldItem.display_name == newItem.display_name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CriticViewHolder {
        return CriticViewHolder(ItemCriticsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CriticViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class CriticViewHolder(private val binding: ItemCriticsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                criticClickListener?.onCriticClicked(
                    binding,
                    getItem(absoluteAdapterPosition) as Critic
                )
            }
        }

        fun bind(item: Critic) = with(binding) {
            ViewCompat.setTransitionName(binding.ivAvatar, "avatar_${item.sort_name}")
            ViewCompat.setTransitionName(binding.tvName, "name_${item.sort_name}")
            critic = item
        }
    }

    interface CriticClickListener {
        fun onCriticClicked(binding: ItemCriticsBinding, critic: Critic)
    }
}
