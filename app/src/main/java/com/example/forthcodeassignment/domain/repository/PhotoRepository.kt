package com.example.forthcodeassignment.domain.repository

import com.example.forthcodeassignment.domain.entities.Photo
import com.example.forthcodeassignment.domain.util.AppResult

interface PhotoRepository {
    suspend fun getPhotos() : AppResult<List<Photo>>
}