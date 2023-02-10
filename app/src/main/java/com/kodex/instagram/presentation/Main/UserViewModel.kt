package com.kodex.instagram.presentation.Main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.kodex.instagram.domain.model.User
import com.kodex.instagram.domain.use_cases.UserUseCases.UserUseCase
import com.kodex.instagram.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val auth : FirebaseAuth,
    private val userUseCase: UserUseCase
): ViewModel() {

    private val userid = auth.currentUser?.uid
    private val _getUserData = mutableStateOf< Response<User?>>(Response.Success(null))
    val getUserData : State<Response<User?>> = _getUserData

    private val _setUserData = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val setUserData : State<Response<Boolean>> = _setUserData

    fun getUserInfo(){
        if(userid != null){
            viewModelScope.launch {
                userUseCase.getUserDetails(userid = userid).collect{
                    _getUserData.value = it
                }
            }
        }
    }
    fun setUserInfo(name: String, userName: String, bio: String, websiteUrl: String){
        if(userid!=null){
            viewModelScope.launch {
                userUseCase.setUserDetails(
                    userid = userid,
                    name = name,
                    userName = userName,
                    bio = bio,
                    websiteUrl = websiteUrl
                ).collect{
                    _setUserData.value = it
                }
            }
        }
    }

}