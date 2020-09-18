package com.example.xfit.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xfit.R
import com.example.xfit.adapters.WorkoutTypeRecyclerView
import com.example.xfit.network.NetworkState
import com.example.xfit.utilities.AlertDialog
import com.example.xfit.utilities.AppUtils
import com.example.xfit.utilities.Injectors
import com.example.xfit.viewmodel.WorkoutViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.workout_fragment.*


class WorkoutsFragment : Fragment() {

    private val workoutAdapter = WorkoutTypeRecyclerView()

    companion object {
        fun newInstance() = WorkoutsFragment()
    }

    private val viewModel: WorkoutViewModel by viewModels {
        Injectors.provideWorkOutFactory()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.workout_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        seUpRecyclerView()
        observeDataAndFeedToViews()
    }

    private fun observeDataAndFeedToViews() {
        viewModel.results.observe(viewLifecycleOwner) { state ->
            when (state) {
                NetworkState.Loading -> activity?.progress?.visibility = View.VISIBLE
                is NetworkState.Content -> {
                    activity?.progress?.visibility = View.GONE
                    workoutAdapter.submitList(state.data)
                }
                is NetworkState.Error -> {
                    activity?.progress?.visibility = View.GONE
                    Toast.makeText(
                        activity, state.throwable.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun seUpRecyclerView() {
        if (!AppUtils.isOnline(requireContext())) {
            val alertDialog = AlertDialog()
            alertDialog.networkAlertError(requireContext())
        }

        rv_workout_type.layoutManager = LinearLayoutManager(activity)
        rv_workout_type.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        rv_workout_type.adapter = workoutAdapter
        viewModel.getWorkoutType()
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as AppCompatActivity?)?.supportActionBar?.title = "Workout"
        super.onCreateOptionsMenu(menu, inflater)
    }

}