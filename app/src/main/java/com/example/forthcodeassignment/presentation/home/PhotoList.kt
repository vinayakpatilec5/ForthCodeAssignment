package com.example.forthcodeassignment.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.forthcodeassignment.domain.entities.Photo

@Composable
fun PhotoList(list: List<Photo>) {
    val gridState: LazyGridState = rememberLazyGridState()
    val configuration = LocalConfiguration.current
    val size = configuration.screenWidthDp.dp / 2

    LazyVerticalGrid(columns = GridCells.Adaptive(size), state = gridState) {
        items(list.size) { index ->
            ImageCard(data = list[index])
        }
    }
}


@Composable
fun ImageCard(data: Photo) {
    Column {
        SubcomposeAsyncImage(model = data.url,
            contentDescription = data.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp)
                .padding(4.dp)
                .clickable {
                    //click
                })
        Text(text = data.title)
    }

}
