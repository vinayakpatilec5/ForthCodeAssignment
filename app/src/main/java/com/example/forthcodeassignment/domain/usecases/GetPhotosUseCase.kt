package com.example.forthcodeassignment.domain.usecases

import com.example.forthcodeassignment.domain.entities.Photo
import com.example.forthcodeassignment.domain.repository.PhotoRepository
import com.example.forthcodeassignment.domain.util.AppResult
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(private val repository: PhotoRepository) {
    //we can write additional login if any here
    suspend operator fun invoke() : AppResult<List<Photo>>  = repository.getPhotos()
}