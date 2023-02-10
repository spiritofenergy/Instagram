package com.kodex.instagram.domain.use_cases.UserUseCases

import com.kodex.instagram.domain.repository.UserRepository
import javax.inject.Inject

class SetUserDetails @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke (
        userid: String,
        name: String,
        userName: String,
        bio: String,
        websiteUrl: String
    ) =
        repository.setUserDetails(
        userid = userid,
        name = name,
        userName = userName,
        bio = bio,
        websiteUrl = websiteUrl
    )
}