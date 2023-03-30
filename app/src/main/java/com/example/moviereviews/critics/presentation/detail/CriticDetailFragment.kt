package com.example.moviereviews.critics.presentation.detail

import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.example.moviereviews.R
import com.example.moviereviews.core.BaseFragment
import com.example.moviereviews.databinding.FragmentCriticDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CriticDetailFragment :
    BaseFragment<FragmentCriticDetailBinding, CriticDetailViewModel>() {
    private val criticDetailViewModel: CriticDetailViewModel by hiltNavGraphViewModels(R.id.criticDetailFragment)
    private val args: CriticDetailFragmentArgs by navArgs()

    override val layoutId: Int
        get() = R.layout.fragment_critic_detail

    override fun getVM(): CriticDetailViewModel = criticDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            context?.let {
                TransitionInflater.from(it).inflateTransition(android.R.transition.move)
            }
    }

    override fun bindVM(binding: FragmentCriticDetailBinding, vm: CriticDetailViewModel) {
        with(binding) {
            critic = args.critic
            ViewCompat.setTransitionName(binding.ivAvatar, "avatar_${args.critic.sort_name}")
            ViewCompat.setTransitionName(binding.tvName, "name_${args.critic.sort_name}")
        }
    }
}