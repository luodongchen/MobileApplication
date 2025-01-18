package com.example.homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.databinding.ItemRecipeBinding

class RecipeAdapter(
    private var recipeList: List<Recipe>,
    private val listener: OnRecipeClickListener
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {


    class RecipeViewHolder(private val binding: ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe, listener: OnRecipeClickListener) {
            binding.recipeTitle.text = recipe.title
            binding.description.text = recipe.description

            // Example: Set click listeners
            binding.likeButton.setOnClickListener { listener.onLikeClick(recipe) }
            binding.shareButton.setOnClickListener { listener.onShareClick(recipe) }
            binding.root.setOnClickListener { listener.onRecipeClick(recipe) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipeList[position], listener)
    }

    override fun getItemCount(): Int = recipeList.size

    fun updateRecipes(newRecipes: List<Recipe>) {
        if (recipeList != newRecipes) {
            recipeList = newRecipes
            notifyDataSetChanged()
        }
    }
}

interface OnRecipeClickListener {
    fun onRecipeClick(recipe: Recipe)
    fun onLikeClick(recipe: Recipe)
    fun onShareClick(recipe: Recipe)
}
