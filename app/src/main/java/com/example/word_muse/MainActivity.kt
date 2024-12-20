package com.example.word_muse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.word_muse.databinding.ActivityMainBinding
import com.example.word_muse.ui.favorite.FavoriteFragment
import com.example.word_muse.ui.home.HomeFragment
import com.example.word_muse.ui.users.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Navigation setup
        //nav should be considered as top level destinations.
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_favorites, R.id.navigation_user
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Navigation switching
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_view)

        val home = HomeFragment()
        val favorite = FavoriteFragment()
        val user = UserFragment()

        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.navigation_home -> fragment = home
                R.id.navigation_favorites -> fragment = favorite
                R.id.navigation_user -> fragment = user
            }
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
            true
        }

//          Database calls
//          Crash?!?!
//
//        val dbHelper = DatabaseHelper(this, null).writableDatabase
//        val testUser = ContentValues().apply {
//            put(DatabaseHelper.USERNAME_COL, "SomeName")
//            put(DatabaseHelper.PASSWORD_COL, "SomePassword")
//        }
//        val testFavorite = ContentValues().apply {
//            put(DatabaseHelper.WORD_COL, "Test")
//        }
//
//        val newUserRow = dbHelper.insert(DatabaseHelper.USER_TABLE, null, testUser)
//        val newFavoriteRow = dbHelper.insert(DatabaseHelper.FAVORITE_TABLE, null, testUser)

        //Search view calls


        //Recycle View calls
    }
}