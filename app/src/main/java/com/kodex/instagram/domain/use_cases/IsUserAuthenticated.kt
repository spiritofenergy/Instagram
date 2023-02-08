package com.kodex.instagram.domain.use_cases

import com.kodex.instagram.domain.repository.AuthenticationRepository
import javax.inject.Inject

class IsUserAuthenticated @Inject constructor(
    private val repository: AuthenticationRepository
){
    operator fun invoke() = repository.isUserAuthenticatedFirebase()
}