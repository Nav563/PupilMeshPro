package com.navneet.pupilmeshpro

import androidx.room.Database
import com.navneet.pupilmeshpro.domain.entities.User
import com.navneet.pupilmeshpro.domain.entities.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : androidx.room.RoomDatabase() {
    abstract fun userDao(): UserDao
}