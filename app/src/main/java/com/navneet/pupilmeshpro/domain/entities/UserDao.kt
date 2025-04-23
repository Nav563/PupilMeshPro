package com.navneet.pupilmeshpro.domain.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM users WHERE isLoggedIn = 1")
    fun getLoggedInUser(): Flow<User?>

    @Query("UPDATE users SET isLoggedIn = :isLoggedIn WHERE email = :email")
    suspend fun updateLoggedInStatus(email: String, isLoggedIn: Boolean)

}