package com.example.forthcodeassignment.data.remote

import com.example.forthcodeassignment.data.entities.PhotoData
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoDataApi {
    @GET("photos")
    suspend fun getPhotos(): List<PhotoData>
}