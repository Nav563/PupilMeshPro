package com.navneet.pupilmeshpro.domain

class UserRepository @Inject constructor(private val userDao: UserDao)  {
    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }
    suspend fun getUserByEmail(email: String)
        = userDao.getUserByEmail(email)

    fun getLoggedInUser(): Flow<User?> =
         userDao.getLoggedInUser()

    suspend fun updateLoggedInStatus(email: String, isLoggedIn: Boolean) =
        userDao.updateLoggedInStatus(email, isLoggedIn)
}