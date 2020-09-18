package com.example.xfit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.xfit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            workout()
        setupClickBottomNavigation()
    }

    override fun getActionBar(): android.app.ActionBar? {
        return super.getActionBar()
    }

    private fun setupClickBottomNavigation() {
        bottomNavBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_workouts -> workout()
                R.id.action_yoga -> yoga()
                R.id.action_meal -> meal()
                R.id.action_help -> help()
                else -> false
            }
        }
    }

    private fun workout(): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                WorkoutsFragment.newInstance()
            )
            .commit()
        supportActionBar?.title = "Workout"
        return true
    }

    private fun yoga(): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                YogaFragment.newInstance()
            )
            .commit()
        supportActionBar?.title = "Yoga"
        return true
    }

    private fun meal(): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                MealFragment.newInstance()
            )
            .commit()
        supportActionBar?.title = "Meal"
        return true
    }

    private fun help(): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HelpFragment.newInstance()).commit()
        supportActionBar?.title = "Help"

        return true
    }
}