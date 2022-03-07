package com.example.beank9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.beank9.fragments.FeedFragment
import com.example.beank9.fragments.LocationFragment
import com.example.beank9.fragments.StatusFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val statusFragment = StatusFragment()
        val locationFragment = LocationFragment()
        val feedFragment = FeedFragment()

        makeCurrentFragment(statusFragment)



        BottomNavigationView.OnNavigationItemReselectedListener { item ->
            when (item.itemId){
                R.id.ic_status -> {
                    makeCurrentFragment(statusFragment)
                }
                R.id.ic_location -> {
                    makeCurrentFragment(locationFragment)
                }
                R.id.ic_feed -> {
                    makeCurrentFragment(feedFragment)
                }
            }

        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

}