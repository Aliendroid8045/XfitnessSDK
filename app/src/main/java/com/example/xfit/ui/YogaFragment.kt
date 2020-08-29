package com.example.xfit.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.xfit.R
import com.example.xfit.viewmodel.YogaViewModel

class YogaFragment : Fragment() {

    companion object {
        fun newInstance() = YogaFragment()
    }

    private lateinit var viewModel: YogaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.yoga_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(YogaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}