package com.example.xfit.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.xfit.R

class MealFragment : Fragment() {

    companion object {
        fun newInstance() = MealFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.meal_fragment, container, false)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as AppCompatActivity?)?.supportActionBar?.title = "Meal"
        super.onCreateOptionsMenu(menu, inflater)
    }

}