//Like JS

package com.example.word_muse.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.word_muse.databinding.FragmentHomeBinding
import com.example.word_muse.databinding.FragmentHomeBinding.inflate
import android.widget.SearchView;
import com.example.word_muse.DictionaryAPI
import com.example.word_muse.SearchApiService

class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
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


    //Calling view model

    fun search(query: String){
        //Call the api to make the search using
        //https://api.dictionaryapi.dev/api/v2/entries/en/<word> "<word>" should be the word that the user is requesting to search

        val url = "https://api.dictionaryapi.dev/api/v2/entries/en/"
        var searchBar: SearchView? = null
        var adapter: ArrayAdapter<String>? = null

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                DictionaryAPI.retrofitService.search(query)

                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                //Clear results
                return false
            }
        })
    }

    fun favorite(){
        //Just a simple check or uncheck for the favorite
    }
}
