package com.example.whoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.menucontabs.GalleryFragment
import com.example.menucontabs.HomeFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val tabLayout: TabLayout = findViewById(R.id.tabs)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            lateinit var fragment: Fragment


            override fun onTabSelected(tab: TabLayout.Tab) {

                when (tab.position) {
                    0 -> {
                        fragment = HomeFragment()
                    }
                    1 -> {
                        fragment = GalleryFragment()
                    }
                }
                supportFragmentManager.beginTransaction().replace(R.id.content_fragment, fragment!!)
                    .commit()
                supportActionBar?.setTitle(tab.text)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        }

        )
    }
}