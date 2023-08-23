package com.basew.base.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.basew.base.R
import com.basew.base.common.Resource
import com.basew.base.databinding.FragmentMainBinding
import com.basew.core.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(
    layoutId = R.layout.fragment_main,
    viewModelClass = MainViewModel::class.java
) {
    override fun onInitDataBinding() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.pictureOfDay.collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        binding.progress.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        // Başarı durumunda ne yapılması gerektiğini belirtin
                        // Örneğin: resource.data kullanarak UI'ı güncelleyin
                        binding.progress.visibility = View.GONE
                        binding.planetTitle.visibility = View.VISIBLE
                        binding.planetTitle.text = resource.data.title.toString()
                    }
                    is Resource.Error -> {
                        // Hata durumunda ne yapılması gerektiğini belirtin
                        // Örneğin: resource.throwable kullanarak hatayı gösterin

                        Log.e("hata", resource.throwable.toString())
                    }

                    else -> {}
                }
            }
        }
    }
}