package com.example.xfit.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.xfit.R

class HelpFragment : Fragment() {

    companion object {
        fun newInstance() = HelpFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.help_fragment, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as AppCompatActivity?)?.supportActionBar?.title = "Help"
        super.onCreateOptionsMenu(menu, inflater)
    }

}