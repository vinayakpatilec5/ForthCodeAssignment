package com.example.forthcodeassignment.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forthcodeassignment.domain.entities.Photo
import com.example.forthcodeassignment.domain.usecases.GetPhotosUseCase
import com.example.forthcodeassignment.domain.util.AppResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPhotosUseCase: GetPhotosUseCase) :
    ViewModel() {
    sealed class UIState {
        data class Detail(val data: List<Photo>) : UIState()
        data class Error(val message: String?) : UIState()
        data object Loading : UIState()
    }

    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            getPhotosUseCase().let {
                when (it) {
                    is AppResult.Success -> _uiState.emit(UIState.Detail(it.data))
                    is AppResult.Error -> _uiState.emit(UIState.Error(it.error.message))
                }
            }
        }
    }
}