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
import kotlinx.android.synthetic.main.workout_type_card.view.*

class WorkoutTypeRecyclerView : ListAdapter<WorkoutType, WorkoutTypeRecyclerView.WorkoutHolder>(
    WorkoutHolder.WorkoutDiffer
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutHolder {
        val inflatedView = parent.inflate(R.layout.workout_type_card, false)
        return WorkoutHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: WorkoutHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    class WorkoutHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data: WorkoutType) {
            view.tv_workout_type.text = data.workoutname
            Glide.with(view.context)
                .load(data.image)
                .into(view.iv_workout_type)
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