package com.synac.dailyplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.synac.dailyplanner.entity.PlanDatabase
import com.synac.dailyplanner.presentation.screenui.DailyPlannerScreen
import com.synac.dailyplanner.presentation.viewmodel.PlanViewModel
import com.synac.dailyplanner.repository.PlanRepository

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize database, repository, and ViewModel
        val database = PlanDatabase.getDatabase(applicationContext)
        val repository = PlanRepository(database.planDao())

        val viewModel: PlanViewModel by viewModels {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    @Suppress("UNCHECKED_CAST")
                    return PlanViewModel(repository) as T
                }
            }
        }
        setContent {
            DailyPlannerScreen(viewModel = viewModel)
        }
    }
}
