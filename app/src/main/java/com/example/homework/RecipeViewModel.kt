package com.example.homework

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class RecipeViewModel : ViewModel() {
    private val _recipes = listOf(
        Recipe(1, "Capuccino", "A classic coffee drink with milk", R.drawable.capuccino),
        Recipe(2, "Latte", "A creamy coffee-based beverage", R.drawable.latte),
        Recipe(3, "Espresso", "Strong and concentrated coffee", R.drawable.espresso),
        Recipe(4, "Mocha", "A chocolate-flavored coffee", R.drawable.mocha),
        Recipe(5, "Americano", "An espresso diluted with hot water", R.drawable.americano)
    )

    private val _filteredRecipes = MutableStateFlow<List<Recipe>>(_recipes)
    val filteredRecipes: StateFlow<List<Recipe>> = _filteredRecipes.asStateFlow()

    private var lastQuery: String? = null

    fun searchRecipes(query: String) {
        if (query.length < 3) {
            _filteredRecipes.update { _recipes }
            return
        }

        val normalizedQuery = query.lowercase()
        if (lastQuery == normalizedQuery) return // Avoid unnecessary updates if query hasn't changed

        lastQuery = normalizedQuery
        _filteredRecipes.update {
            _recipes.filter { recipe ->
                recipe.title.contains(normalizedQuery, ignoreCase = true) ||
                        recipe.description.contains(normalizedQuery, ignoreCase = true)
            }
        }
    }
}
