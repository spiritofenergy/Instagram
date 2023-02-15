package com.kodex.instagram.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.kodex.instagram.data.AuthenticationRepositoryImpl
import com.kodex.instagram.data.PostRepositoryImpl
import com.kodex.instagram.data.UserRepositoryImpl
import com.kodex.instagram.domain.repository.AuthenticationRepository
import com.kodex.instagram.domain.repository.PostRepository
import com.kodex.instagram.domain.repository.UserRepository
import com.kodex.instagram.domain.use_cases.*
import com.kodex.instagram.domain.use_cases.AuthenticationUseCases.*
import com.kodex.instagram.domain.use_cases.PostsUseCases.GetAllPosts
import com.kodex.instagram.domain.use_cases.PostsUseCases.PostsUseCase
import com.kodex.instagram.domain.use_cases.PostsUseCases.UploadPost
import com.kodex.instagram.domain.use_cases.UserUseCases.GetUserDetails
import com.kodex.instagram.domain.use_cases.UserUseCases.SetUserDetails
import com.kodex.instagram.domain.use_cases.UserUseCases.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InstagramModule {

    @Singleton
    @Provides
    fun provideFirebaseAuthentication(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Singleton
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Singleton
    @Provides
    fun provideFirebaseStorage(): FirebaseStorage {
        return FirebaseStorage.getInstance()
    }
    @Singleton
    @Provides
    fun provideAuthenticationRepository(auth: FirebaseAuth, firestore: FirebaseFirestore): AuthenticationRepository {
        return AuthenticationRepositoryImpl(auth = auth, firestore = firestore)
    }

    @Singleton
    @Provides
    fun provideAuthUseCases(repository: AuthenticationRepository) = AuthenticationUseCase(
        isUserAuthenticated = IsUserAuthenticated(repository = repository),
        firebaseAuthState = FirebaseAuthState(repository = repository),
        firebaseSignOut = FirebaseSignOut(repository = repository),
        firebaseSignIn = FirebaseSignIn(repository = repository),
        firebaseSingUp = FirebaseSingUp(repository = repository)
    )

    @Singleton
    @Provides
    fun provideUserRepository(firebaseFirestore: FirebaseFirestore):UserRepository{
        return UserRepositoryImpl(firebaseFirestore = firebaseFirestore)
    }

    @Singleton
    @Provides
    fun provideUserUseCase(repository: UserRepository) = UserUseCase(
        getUserDetails = GetUserDetails(repository = repository),
        setUserDetails = SetUserDetails(repository = repository)
    )

    @Singleton
    @Provides
    fun providePostRepository(firebaseFirestore: FirebaseFirestore): PostRepository{
        return PostRepositoryImpl(firebaseFirestore = firebaseFirestore)
    }

    @Singleton
    @Provides
    fun providePostUseCase(repository: PostRepository) = PostsUseCase(
        getAllPosts = GetAllPosts(repository = repository),
        uploadPost = UploadPost(repository = repository)
    )




}