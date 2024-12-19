//Like JS

package com.example.word_muse.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.MenuInflater
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.word_muse.API.RetrofitClient
import com.example.word_muse.R
import com.example.word_muse.databinding.FragmentHomeBinding
import com.example.word_muse.databinding.FragmentHomeBinding.inflate



class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = inflate(
            inflater,
            container,
            false
        )
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//BINDING METHODS
    //API Call
    private val _wordData = MutableLiveData("No Data")
    val wordData: LiveData<String> get() = _wordData
    suspend fun getSearch(word: String? = null){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Handle search query submission
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Filter list or perform search operation
                return false
            }
        })
        _wordData.value = RetrofitClient.searchApiService.search(word.toString()).toString()
    }

}