package com.example.xfit.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.xfit.R
import com.example.xfit.data.WorkoutType
import com.example.xfit.utilities.inflate
import kotlinx.android.synthetic.main.excercise_view_card.view.*

class ArmRecyclerView : ListAdapter<WorkoutType, ArmRecyclerView.ArmWorkoutHolder>(
    ArmWorkoutHolder.WorkoutDiffer
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArmWorkoutHolder {
        val inflatedView = parent.inflate(R.layout.excercise_view_card, false)
        return ArmWorkoutHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ArmWorkoutHolder, position: Int) {
        holder.bindItem(getItem(position))

    }

    class ArmWorkoutHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data: WorkoutType) {
            view.workout_name.text = data.workoutname
            Glide.with(view.context)
                .load(data.image)
                .into(view.iv_types)
        }
        init {
            view.setOnClickListener() {

            }
        }

        object WorkoutDiffer : DiffUtil.ItemCallback<WorkoutType>() {
            override fun areItemsTheSame(
                oldItem: WorkoutType,
                newItem: WorkoutType
            ): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(
                oldItem: WorkoutType,
                newItem: WorkoutType
            ): Boolean {
                return oldItem == newItem
            }
        }

    }
}