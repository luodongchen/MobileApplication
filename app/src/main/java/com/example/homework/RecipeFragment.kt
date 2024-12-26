package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RecipeFragment : Fragment(), OnRecipeClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipe, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)

        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Set up Adapter
        val recipeList = getSampleRecipes()
        recyclerView.adapter = RecipeAdapter(recipeList, this)

        return view
    }


    private fun getSampleRecipes(): List<Recipe> {
        return listOf(
            Recipe(1, "Capuccino", R.drawable.capuccino),
            Recipe(2, "Latte", R.drawable.latte),
            Recipe(3, "Espresso", R.drawable.espresso)
        )
    }

    // Implementing OnRecipeClickListener interface methods
    override fun onRecipeClick(recipe: Recipe) {
        // Handle recipe click (e.g., show details)
        println("Clicked on recipe: ${recipe.title}")
    }

    override fun onLikeClick(recipe: Recipe) {
        // Handle like button click
        println("Liked recipe: ${recipe.title}")
    }

    override fun onShareClick(recipe: Recipe) {
        // Handle share button click
        println("Shared recipe: ${recipe.title}")
    }

    companion object {
        fun newInstance() = RecipeFragment()
    }
}
