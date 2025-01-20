package com.example.homework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay




class RecipeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState(isLoading = true, recipes = emptyList()))
    val uiState: StateFlow<UiState> = _uiState

    private val _recipes = listOf(
        Recipe(1, "Capuccino", "A classic coffee drink with milk", R.drawable.capuccino),
        Recipe(2, "Latte", "A creamy coffee-based beverage", R.drawable.latte),
        Recipe(3, "Espresso", "Strong and concentrated coffee", R.drawable.espresso),
        Recipe(4, "Mocha", "A chocolate-flavored coffee", R.drawable.mocha),
        Recipe(5, "Americano", "An espresso diluted with hot water", R.drawable.americano)
    )

    private var lastQuery: String? = null

    init {
        loadInitialRecipes()
    }

    private fun loadInitialRecipes() {
        viewModelScope.launch {
            delay(2000) // Simulate 2-second loading
            _uiState.update { it.copy(isLoading = false, recipes = _recipes) }
        }
    }

    fun searchRecipes(query: String) {
        if (query.length < 3) {
            _uiState.update { it.copy(recipes = _recipes) }
            return
        }

        val normalizedQuery = query.lowercase()
        if (lastQuery == normalizedQuery) return // Avoid redundant queries

        lastQuery = normalizedQuery
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            delay(2000) // Simulate 2-second loading
            val filteredRecipes = _recipes.filter {
                it.title.contains(normalizedQuery, ignoreCase = true) ||
                        it.description.contains(normalizedQuery, ignoreCase = true)
            }
            _uiState.update { it.copy(isLoading = false, recipes = filteredRecipes) }
        }
    }

}
