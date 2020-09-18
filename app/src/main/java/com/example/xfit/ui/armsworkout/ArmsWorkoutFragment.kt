package com.example.xfit.ui.armsworkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.xfit.R
import com.example.xfit.adapters.ArmRecyclerView
import com.example.xfit.utilities.AlertDialog
import com.example.xfit.utilities.AppUtils
import com.example.xfit.utilities.Injectors
import com.example.xfit.viewmodel.WorkoutViewModel
import kotlinx.android.synthetic.main.fragment_arms_workout.*
import kotlinx.android.synthetic.main.workout_fragment.rv_workout_type


class ArmsWorkoutFragment : Fragment() {

    private val workoutExerciseAdapter = ArmRecyclerView()

    companion object {
        fun newInstance() = ArmsWorkoutFragment()
    }

    private val viewModel: WorkoutViewModel by viewModels {
        Injectors.provideWorkOutFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_arms_workout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        seUpRecyclerView()
    }

    private fun seUpRecyclerView() {
        if (!AppUtils.isOnline(requireContext())) {
            val alertDialog = AlertDialog()
            alertDialog.networkAlertError(requireContext())
        }

        rv_types_of_exercise.layoutManager = GridLayoutManager(activity, 2)
        rv_workout_type.adapter = workoutExerciseAdapter
        viewModel.getWorkoutType()
    }
}