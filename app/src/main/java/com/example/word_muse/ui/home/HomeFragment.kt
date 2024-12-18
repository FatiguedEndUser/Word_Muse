//Like JS

package com.example.word_muse.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.word_muse.API.RetrofitClient
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
//    //API Call
//    private val _wordData = MutableLiveData("No Data")
//    val wordData: LiveData<String> get() = _wordData
//
//    //TODO: Figure out how to append the word to the end of the endpoint for the api call.
//    //      we need too follow up with that and attach
//    private suspend fun getSearch(word: String? = null){
//        _wordData.value = RetrofitClient.searchApiService.search(word).toString()
//    }

    private suspend fun search(text: String){
        val searchBar: SearchView? = null
        searchBar.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }
        })
    }
}
