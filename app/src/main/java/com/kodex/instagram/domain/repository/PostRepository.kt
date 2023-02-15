package com.kodex.instagram.domain.repository

import android.text.BoringLayout
import com.kodex.instagram.domain.model.Post
import com.kodex.instagram.util.Response
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getAllPosts(userid: String): Flow<Response<List<Post>>>

    fun uploadPost(
        postImage: String,
        postDescription: String,
        time: Long,
        userId : String,
        userName : String,
        userImage: String,
    ): Flow<Response<Boolean>>
}