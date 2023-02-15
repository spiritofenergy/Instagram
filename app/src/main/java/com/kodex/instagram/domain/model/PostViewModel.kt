package com.kodex.instagram.domain.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.kodex.instagram.domain.use_cases.PostsUseCases.PostsUseCase
import com.kodex.instagram.domain.use_cases.UserUseCases.UserUseCase
import com.kodex.instagram.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postUserUseCase: PostsUseCase,
    private val auth: FirebaseAuth
) : ViewModel(){

    private val _postData = mutableStateOf<Response<List<Post>>>(Response.Loading)
    val postData : MutableState<Response<List<Post>>> = _postData

    private val _uploadPostData = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val uploadPostData : MutableState<Response<Boolean>> = _uploadPostData

    fun getAllPosts (userid: String) {
        viewModelScope.launch {
            postUserUseCase.getAllPosts(userid).collect {
                _postData.value = it
            }
        }
    }
    fun uploadPost(
        postImage: String,
        postDescription: String,
        time: Long,
        userid: String,
        userName: String,
        userImage: String
    ) {
        viewModelScope.launch {
            postUserUseCase.uploadPost(
                postImage = postImage,
                postDescription = postDescription,
                time = time,
                userid = userid,
                userName = userName,
                userImage = userImage
            ).collect {
                _uploadPostData.value = it
            }
        }
    }
}