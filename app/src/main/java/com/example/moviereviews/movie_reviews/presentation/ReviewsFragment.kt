package com.example.moviereviews.movie_reviews.presentation

import android.content.Intent
import android.net.Uri
import android.webkit.URLUtil
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.paging.LoadState
import com.example.moviereviews.R
import com.example.moviereviews.core.BaseFragment
import com.example.moviereviews.core.util.PagingLoadStateAdapter
import com.example.moviereviews.databinding.FragmentReviewsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class ReviewsFragment : BaseFragment<FragmentReviewsBinding, ReviewsViewModel>(),
    ReviewsAdapter.ReviewClickListener {

    private val reviewsViewModel: ReviewsViewModel by hiltNavGraphViewModels(R.id.navigation_reviews)

    @Inject
    lateinit var reviewsAdapter: ReviewsAdapter

    override val layoutId: Int
        get() = R.layout.fragment_reviews

    override fun getVM(): ReviewsViewModel = reviewsViewModel

    override fun bindVM(binding: FragmentReviewsBinding, viewModel: ReviewsViewModel) {
        with(binding) {
            with(reviewsAdapter) {
                recyclerView.apply {
                    postponeEnterTransition()
                    viewTreeObserver.addOnPreDrawListener {
                        startPostponedEnterTransition()
                        true
                    }
                }
                recyclerView.adapter = withLoadStateHeaderAndFooter(
                    header = PagingLoadStateAdapter(this),
                    footer = PagingLoadStateAdapter(this)
                )

                swipeRefresh.setOnRefreshListener { refresh() }

                reviewClickListener = this@ReviewsFragment

                with(viewModel) {
                    launchOnLifecycleScope {
                        moviesPreviewsFlow.collectLatest { submitData(it) }
                    }
                    launchOnLifecycleScope {
                        loadStateFlow.collectLatest {
                            swipeRefresh.isRefreshing = it.refresh is LoadState.Loading
                        }
                    }
                }
            }
        }
    }

    override fun onReviewButtonClicked(url: String) {
        openBrowser(url)
    }

    private fun openBrowser(url: String) {
        val formattedUrl = with(url.trim()) {
            if (URLUtil.isHttpUrl(this) || URLUtil.isHttpsUrl(this)) {
                this
            } else {
                "http://$this"
            }
        }
        val browserIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(formattedUrl)
        ).apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }

        startActivity(browserIntent)
    }
}