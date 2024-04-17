package com.example.forthcodeassignment.data.repository

import com.example.forthcodeassignment.data.mapper.toDomain
import com.example.forthcodeassignment.data.remote.PhotoDataApi
import com.example.forthcodeassignment.domain.repository.PhotoRepository
import com.example.forthcodeassignment.domain.entities.Photo
import com.example.forthcodeassignment.domain.util.AppResult
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(private val api: PhotoDataApi) : PhotoRepository {
    override suspend fun getPhotos(): AppResult<List<Photo>> = try {
        AppResult.Success(
            data = api.getPhotos().map {
                it.toDomain()
            }
        )
    } catch (e: Exception) {
        AppResult.Error(e)
    }
}