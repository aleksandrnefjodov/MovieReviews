package com.example.moviereviews.movie_reviews.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviereviews.databinding.ItemReviewBinding
import com.example.moviereviews.movie_reviews.domain.model.MovieReview
import javax.inject.Inject

class ReviewsAdapter @Inject constructor() :
    PagingDataAdapter<MovieReview, ReviewsAdapter.MovieViewHolder>(DiffCallback) {
    var reviewClickListener: ReviewClickListener? = null

    companion object DiffCallback : DiffUtil.ItemCallback<MovieReview>() {
        override fun areItemsTheSame(oldItem: MovieReview, newItem: MovieReview): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MovieReview, newItem: MovieReview): Boolean {
            return oldItem.displayTitle == newItem.displayTitle
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        return MovieViewHolder(ItemReviewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class MovieViewHolder(private val binding: ItemReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.buttonGoToReview.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { moviewReview ->
                    reviewClickListener?.onReviewButtonClicked(
                        moviewReview.linkUrl
                    )
                }
            }
        }

        fun bind(item: MovieReview) = with(binding) {
            movieReview = item
        }
    }

    interface ReviewClickListener {
        fun onReviewButtonClicked(url: String)
    }
}
