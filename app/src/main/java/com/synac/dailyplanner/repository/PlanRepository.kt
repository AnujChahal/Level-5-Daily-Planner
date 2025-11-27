package com.synac.dailyplanner.repository

import com.synac.dailyplanner.dao.PlanDao
import com.synac.dailyplanner.presentation.data.Plan

class PlanRepository(private val dao: PlanDao) {
    val allPlans = dao.getAllPlans()

    suspend fun insert(plan: Plan) = dao.insertPlan(plan)
    suspend fun update(plan: Plan) = dao.updatePlan(plan)
    suspend fun delete(plan: Plan) = dao.deletePlan(plan)
}
