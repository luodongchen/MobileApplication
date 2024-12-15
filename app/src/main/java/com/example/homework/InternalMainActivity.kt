package com.example.homework

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InternalMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_main)


        val recipes = listOf(
            Recipe(1, "Capuccino", R.drawable.capuccino),
            Recipe(2, "Latte", R.drawable.latte),
            Recipe(3, "Espresso", R.drawable.espresso)
        )


        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecipeAdapter(recipes, this)
    }


    fun onRecipeClick(recipe: Recipe) {
        Toast.makeText(this, "点击了: ${recipe.title}", Toast.LENGTH_SHORT).show()
    }


    fun onLikeClick(recipe: Recipe) {
        Toast.makeText(this, "点赞了: ${recipe.title}", Toast.LENGTH_SHORT).show()
    }


    fun onShareClick(recipe: Recipe) {
        Toast.makeText(this, "分享了: ${recipe.title}", Toast.LENGTH_SHORT).show()
    }
}