package com.kodex.instagram.domain.use_cases.PostsUseCases

import com.kodex.instagram.domain.repository.PostRepository
import javax.inject.Inject

class GetAllPosts @Inject constructor(
    private val repository: PostRepository
) {
    operator fun  invoke(userid: String) = repository.getAllPosts(userid= userid)
}