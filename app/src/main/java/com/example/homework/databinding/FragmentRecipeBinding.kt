package com.example.homework.databinding


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.homework.R

class FragmentRecipeBinding private constructor(
    val root: View,
    val searchView: SearchView,
    val recyclerView: RecyclerView
) : ViewBinding {
    companion object {
        fun inflate(
            inflater: LayoutInflater,
            container: ViewGroup?,
            attachToParent: Boolean
        ): FragmentRecipeBinding {
            val root = inflater.inflate(R.layout.fragment_recipe, container, false)
            val searchView = root.findViewById<SearchView>(R.id.search_view)
            val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
            return FragmentRecipeBinding(root, searchView, recyclerView)
        }

        fun bind(root: View): FragmentRecipeBinding {
            val searchView = root.findViewById<SearchView>(R.id.search_view)
            val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
            return FragmentRecipeBinding(root, searchView, recyclerView)
        }
    }

    override fun getRoot(): View = root
}
