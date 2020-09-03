package com.myprohelper.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myprohelper.database.dao.JobListDAO
import com.myprohelper.entity.JobListEntityOrginal

@Database(entities = arrayOf(JobListEntityOrginal::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun jobListDao(): JobListDAO

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase::class.java,
                        "app_database.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }


}