//Like JS

package com.example.word_muse.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
//    //API Call
//    private val _wordData = MutableLiveData("No Data")
//    val wordData: LiveData<String> get() = _wordData
//
//    //TODO: Figure out how to append the word to the end of the endpoint for the api call.
//    //      we need too follow up with that and attach
//    private suspend fun getSearch(word: String? = null){
//        _wordData.value = RetrofitClient.searchApiService.search(word).toString()
//    }

    fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu!!.findItem(R.id.search_view)
        var searchView = searchItem.actionView as android.widget.SearchView
        searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val query = searchView.query.toString()
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Handle search query changes
                return true
            }
        })
        return true
    }
}
