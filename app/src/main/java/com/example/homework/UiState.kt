package com.example.homework

data class UiState(
    val recipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false
)
