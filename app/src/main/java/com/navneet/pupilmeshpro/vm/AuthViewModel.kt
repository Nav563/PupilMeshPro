package com.navneet.pupilmeshpro.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.navneet.pupilmeshpro.domain.UserRepository
import com.navneet.pupilmeshpro.domain.entities.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn

    private val _isSignInSuccess = MutableLiveData<Boolean>()
    val isSignInSuccess: LiveData<Boolean> = _isSignInSuccess

    fun checkLoggedInStatus() {
        viewModelScope.launch {
            userRepository.getLoggedInUser().collect { user : User? ->
                _isLoggedIn.postValue(user?.isLoggedIn ?: false)
            }
        }
    }

    fun signIn(email: String, passwordHash: String) {
        viewModelScope.launch {
            val existingUser = userRepository.getUserByEmail(email)
            if (existingUser != null) {
                if (existingUser.passwordHash == passwordHash) {
                    // Update login status
                    userRepository.updateLoggedInStatus(existingUser.email, true)
                    // Update the live data to trigger the navigation in fragment
                    _isSignInSuccess.value = true

                } else {
                    // Wrong password
                    _isSignInSuccess.value = false
                }
            } else {
                // Create a new user
                val newUser = User(email = email, passwordHash = passwordHash, isLoggedIn = true)
                userRepository.insertUser(newUser)
                // Update the live data to trigger the navigation in fragment
                _isSignInSuccess.value = true
            }
        }
    }

                fun logout() {
        viewModelScope.launch {
            userRepository.getLoggedInUser().collect{ user : User? ->
                if (user != null){
                    launch {
                        userRepository.updateLoggedInStatus(user.email,false)
                    }
                }
            }
        }
    }
}