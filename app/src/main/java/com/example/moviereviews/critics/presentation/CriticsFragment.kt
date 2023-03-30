package com.example.moviereviews.critics.presentation

import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.example.moviereviews.R
import com.example.moviereviews.core.BaseFragment
import com.example.moviereviews.core.util.PagingLoadStateAdapter
import com.example.moviereviews.critics.domain.model.Critic
import com.example.moviereviews.databinding.FragmentCriticsBinding
import com.example.moviereviews.databinding.ItemCriticsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class CriticsFragment : BaseFragment<FragmentCriticsBinding, CriticsViewModel>(),
    CriticsAdapter.CriticClickListener {

    private val criticsViewModel: CriticsViewModel by hiltNavGraphViewModels(R.id.navigation_critics)

    @Inject
    lateinit var criticsAdapter: CriticsAdapter

    override val layoutId: Int
        get() = R.layout.fragment_critics

    override fun getVM(): CriticsViewModel = criticsViewModel

    override fun bindVM(binding: FragmentCriticsBinding, vm: CriticsViewModel) {
        with(binding) {
            with(criticsAdapter) {
                rvCritics.apply {
                    postponeEnterTransition()
                    viewTreeObserver.addOnPreDrawListener {
                        startPostponedEnterTransition()
                        true
                    }
                }
                rvCritics.adapter = withLoadStateHeaderAndFooter(
                    header = PagingLoadStateAdapter(this),
                    footer = PagingLoadStateAdapter(this)
                )

                swipeRefresh.setOnRefreshListener { refresh() }

                criticClickListener = this@CriticsFragment

                with(vm) {
                    launchOnLifecycleScope {
                        criticsFlow.collectLatest { submitData(it) }
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

    override fun onCriticClicked(binding: ItemCriticsBinding, critic: Critic) {
        val extras = FragmentNavigatorExtras(
            binding.ivAvatar to "avatar_${critic.sort_name}",
            binding.tvName to "name_${critic.sort_name}"
        )
        findNavController().navigate(
            CriticsFragmentDirections.actionCriticsToCriticDetail(critic),
            extras
        )
    }
}