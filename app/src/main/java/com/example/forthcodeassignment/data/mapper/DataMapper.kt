package com.example.forthcodeassignment.data.mapper

import com.example.forthcodeassignment.data.entities.PhotoData
import com.example.forthcodeassignment.data.remote.PhotoDataApi
import com.example.forthcodeassignment.domain.entities.Photo

fun PhotoData.toDomain(): Photo {
    return Photo(albumId, id, title, url, thumbnailUrl)
}