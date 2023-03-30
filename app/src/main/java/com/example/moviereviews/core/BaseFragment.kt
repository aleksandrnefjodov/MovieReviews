package com.example.moviereviews.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.moviereviews.core.ext.observe

abstract class BaseFragment<dataBinding : ViewDataBinding, viewModel : BaseViewModel> : Fragment() {
    private lateinit var viewModel: viewModel
    private lateinit var binding: dataBinding

    @get:LayoutRes
    abstract val layoutId: Int

    abstract fun getVM(): viewModel

    abstract fun bindVM(binding: dataBinding, viewModel: viewModel)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getVM()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindVM(binding, viewModel)
        with(viewModel) {
            observe(progressLiveEvent) { show ->
                if (show) (activity as BaseActivity<*, *>).showProgress()
                else (activity as BaseActivity<*, *>).hideProgress()
            }

            observe(errorMessage) { msg ->
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun launchOnLifecycleScope(execute: suspend () -> Unit) {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            execute()
        }
    }
}