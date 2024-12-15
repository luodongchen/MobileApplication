package com.example.homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(
    private val recipeList: List<Recipe>,
    private val listener: OnRecipeClickListener
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {


    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.recipe_image)
        val title: TextView = itemView.findViewById(R.id.recipe_title)
        val likeButton: Button = itemView.findViewById(R.id.like_button)
        val shareButton: Button = itemView.findViewById(R.id.share_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]

        holder.image.setImageResource(recipe.imageResId)
        holder.title.text = recipe.title


        holder.itemView.setOnClickListener {
            listener.onRecipeClick(recipe)
        }


        holder.likeButton.setOnClickListener {
            listener.onLikeClick(recipe)
        }


        holder.shareButton.setOnClickListener {
            listener.onShareClick(recipe)
        }
    }

    override fun getItemCount(): Int = recipeList.size
}


interface OnRecipeClickListener {
    fun onRecipeClick(recipe: Recipe)
    fun onLikeClick(recipe: Recipe)
    fun onShareClick(recipe: Recipe)
}
