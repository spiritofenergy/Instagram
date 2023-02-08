package com.kodex.instagram.domain.use_cases

data class AuthenticationUseCase(
   val  isUserAuthenticated: IsUserAuthenticated,
   val firebaseAuthState: FirebaseAuthState,
   val firebaseSignIn: FirebaseSignIn,
   val firebaseSignOut:FirebaseSignOut,
   val firebaseSingUp: FirebaseSingUp
) {
}