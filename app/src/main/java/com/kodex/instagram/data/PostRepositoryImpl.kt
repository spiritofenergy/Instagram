package com.kodex.instagram.data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.kodex.instagram.domain.model.Post
import com.kodex.instagram.domain.repository.PostRepository
import com.kodex.instagram.util.Response
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val firebaseFirestore: FirebaseFirestore
): PostRepository{

    private var operationSuccessful = false

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getAllPosts(userid: String):
            Flow<Response<List<Post>>> = callbackFlow{
        Response.Loading
        val snapshotListener = firebaseFirestore.collection("posts")
            .whereNotEqualTo("userId",userid)
            .addSnapshotListener{snapshot,e->
                val response = if(snapshot!=null){
                    val postsList = snapshot.toObjects(Post::class.java)
                    Log.d("postLists",postsList.toString())
                    Response.Success<List<Post>>(postsList)
                }
                else{
                    Response.Error(e?.message?:e.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun uploadPost(
        postId: String,
        postImage: String,
        postDescription: String,
        time: Long,
        userId: String,
        userName: String,
        userImage: String,
    ): Flow<Response<Boolean>> = flow{
        operationSuccessful = false
        try {
            val postId = firebaseFirestore.collection("posts").document().id
            val post = Post(
                postImage = postImage,
                postDescription = postDescription,
                postId = postId,
                time = time,
                userName = userName,
                usrImage = userImage,
                userId = userId
            )
            firebaseFirestore.collection("posts")
        }
        catch (e: Exception){
            emit(Response.Error(e.localizedMessage?:"An Unexpected error"))
        }
     }
  }