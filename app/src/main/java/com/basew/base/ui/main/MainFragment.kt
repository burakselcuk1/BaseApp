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
import com.basew.coree.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(
    layoutId = R.layout.fragment_main,
    viewModelClass = MainViewModel::class.java
) {
    override fun onInitDataBinding() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.pictureOfDay.collect { resource ->

            }
        }
    }
}