package com.navneet.pupilmeshpro.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val passwordHash: String,
    @ColumnInfo(name = "isLoggedIn") var isLoggedIn: Boolean = false
)