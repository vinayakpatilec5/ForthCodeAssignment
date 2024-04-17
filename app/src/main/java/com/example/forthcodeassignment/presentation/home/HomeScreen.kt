package com.example.forthcodeassignment.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.forthcodeassignment.presentation.components.ErrorScreen
import com.example.forthcodeassignment.presentation.components.LoadingScreen

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    UiStateScreen(data = uiState)
}

@Composable
fun UiStateScreen(data: HomeViewModel.UIState) {
    when (data) {
        is HomeViewModel.UIState.Detail -> {
            PhotoList(data.data)
        }

        is HomeViewModel.UIState.Error -> {
            ErrorScreen(error = data.message ?: "")
        }

        is HomeViewModel.UIState.Loading -> {
            LoadingScreen()
        }
    }
}