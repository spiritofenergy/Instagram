package com.kodex.instagram.domain.use_cases

import com.kodex.instagram.domain.repository.AuthenticationRepository
import javax.inject.Inject

class FirebaseSingUp @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(email: String, password: String, userName: String)
    = repository.firebaseSingUp(email, password, userName)

}