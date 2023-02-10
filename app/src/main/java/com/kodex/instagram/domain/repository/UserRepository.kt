package com.kodex.instagram.domain.repository

import com.kodex.instagram.domain.model.User
import com.kodex.instagram.util.Response
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUserDetails(userid: String): Flow<Response<User>>
    fun setUserDetails(
        userid: String,
        name: String,
        userName: String,
        bio: String,
        websiteUrl: String
    ):Flow<Response<Boolean>>
}