package com.synac.dailyplanner.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.synac.dailyplanner.dao.PlanDao
import com.synac.dailyplanner.presentation.data.Plan

@Database(entities = [Plan::class], version = 1, exportSchema = false)
abstract class PlanDatabase : RoomDatabase() {
    abstract fun planDao(): PlanDao

    companion object {
        @Volatile private var INSTANCE: PlanDatabase? = null

        fun getDatabase(context: Context): PlanDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlanDatabase::class.java,
                    "plan_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
