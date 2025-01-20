package com.example.homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework.databinding.FragmentRecipeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RecipeFragment : Fragment() {
    private lateinit var binding: FragmentRecipeBinding
    private lateinit var recipeAdapter: RecipeAdapter
    private val recipeViewModel: RecipeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeRecipes()
        setupSearchView()
        setupLogoutButton()
    }

    private fun setupRecyclerView() {
        recipeAdapter = RecipeAdapter(emptyList(), object : OnRecipeClickListener {
            override fun onRecipeClick(recipe: Recipe) { /* Handle recipe click */ }
            override fun onLikeClick(recipe: Recipe) { /* Handle like click */ }
            override fun onShareClick(recipe: Recipe) { /* Handle share click */ }
        })

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = recipeAdapter
    }

    private fun observeRecipes() {
        lifecycleScope.launch {
            recipeViewModel.uiState.collectLatest { uiState ->
                binding.progressBar.visibility = if (uiState.isLoading) View.VISIBLE else View.GONE
                binding.recyclerView.visibility = if (uiState.isLoading) View.GONE else View.VISIBLE

                if (!uiState.isLoading) {
                    recipeAdapter.updateRecipes(uiState.recipes)
                }
            }
        }
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { recipeViewModel.searchRecipes(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { recipeViewModel.searchRecipes(it) }
                return true
            }
        })
    }

    private fun setupLogoutButton() {
        binding.logoutButton.setOnClickListener {
            (requireActivity().application as MyApp).credentialManager.logout()
        }
    }

    companion object {
        fun newInstance(): RecipeFragment {
            return RecipeFragment()
        }
    }
}
