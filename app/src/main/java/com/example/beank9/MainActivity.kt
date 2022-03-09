package com.example.beank9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.beank9.fragments.FeedFragment
import com.example.beank9.fragments.LocationFragment
import com.example.beank9.fragments.StatusFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //supportActionBar?.hide() //hide top title

        //define fragments
        val statusFragment = StatusFragment()
        val locationFragment = LocationFragment()
        val feedFragment = FeedFragment()

        makeCurrentFragment(statusFragment)

        bottom_navigation.setOnItemSelectedListener { item ->  //Navbar listener
            when (item.itemId) {
                R.id.ic_status -> {
                    makeCurrentFragment(statusFragment)
                    true
                }
                R.id.ic_location -> {
                    makeCurrentFragment(locationFragment)
                    true
                }
                R.id.ic_feed -> {
                    makeCurrentFragment(feedFragment)
                    true
                }
                else->false
            }
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

}