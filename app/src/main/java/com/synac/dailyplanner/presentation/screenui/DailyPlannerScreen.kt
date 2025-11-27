package com.synac.dailyplanner.presentation.screenui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.synac.dailyplanner.presentation.data.Plan
import com.synac.dailyplanner.presentation.viewmodel.PlanViewModel

@Composable
fun DailyPlannerScreen(viewModel: PlanViewModel) {
    val plans by viewModel.plans.collectAsState()

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var editingPlan by remember { mutableStateOf<Plan?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Daily Planner", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
        OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("Description") })
        OutlinedTextField(value = date, onValueChange = { date = it }, label = { Text("Date (YYYY-MM-DD)") })

        Button(
            onClick = {
                if (title.isNotBlank() && date.isNotBlank()) {
                    if (editingPlan == null) {
                        // Add new plan
                        viewModel.addPlan(title, description, date)
                    } else {
                        // Edit existing plan
                        viewModel.editPlan(editingPlan!!, title, description, date)
                        editingPlan = null
                    }
                    title = ""; description = ""; date = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(if (editingPlan == null) "Add Plan" else "Update Plan")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(plans) { plan ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(plan.title, style = MaterialTheme.typography.titleMedium)
                        Text(plan.description)
                        Text(plan.date, style = MaterialTheme.typography.bodySmall)

                        Row {
                            Button(onClick = {
                                // Prefill fields for editing
                                title = plan.title
                                description = plan.description
                                date = plan.date
                                editingPlan = plan
                            }) {
                                Text("Edit")
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Button(onClick = { viewModel.deletePlan(plan) }) {
                                Text("Delete")
                            }
                        }
                    }
                }
            }
        }
    }
}
