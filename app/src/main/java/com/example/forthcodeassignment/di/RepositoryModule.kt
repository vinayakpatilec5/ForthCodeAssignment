package com.example.forthcodeassignment.di

import com.example.forthcodeassignment.data.remote.PhotoDataApi
import com.example.forthcodeassignment.data.repository.PhotoRepositoryImpl
import com.example.forthcodeassignment.domain.repository.PhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(api: PhotoDataApi): PhotoRepository {
        return PhotoRepositoryImpl(api)
    }
}