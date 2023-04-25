package com.example.instagramclone.domain.use_cases.UserUseCases

import com.example.instagramclone.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserDetails @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(userid:String) =
        repository.getUserDetails(userid = userid)
}