package com.synac.dailyplanner.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.synac.dailyplanner.presentation.data.Plan
import com.synac.dailyplanner.repository.PlanRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PlanViewModel(private val repository: PlanRepository) : ViewModel() {
    val plans = repository.allPlans
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addPlan(title: String, description: String, date: String) {
        viewModelScope.launch {
            repository.insert(Plan(title = title, description = description, date = date))
        }
    }

    fun updatePlan(plan: Plan) {
        viewModelScope.launch { repository.update(plan) }
    }

    fun deletePlan(plan: Plan) {
        viewModelScope.launch { repository.delete(plan) }
    }

    fun editPlan(plan: Plan, newTitle: String, newDescription: String, newDate: String) {
        viewModelScope.launch {
            val updated = plan.copy(
                title = newTitle,
                description = newDescription,
                date = newDate
            )
            repository.update(updated)
        }
    }

}
