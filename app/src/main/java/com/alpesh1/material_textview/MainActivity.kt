package com.alpesh1.material_textview

import Fragment.Add_Fragment
import Fragment.Trans_Fragment
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alpesh1.material_textview.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)


        binding.bottomicon.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                loadFragment(Add_Fragment())

                when (item.itemId) {

                    R.id.setAdd -> {
                        loadFragment(Add_Fragment())
                    }

                    R.id.trans -> {
                        loadFragment(Trans_Fragment())
                    }

                }

                return true
            }

            private fun loadFragment(fragment: Fragment) {

                supportFragmentManager.beginTransaction().replace(R.id.fragFrame, fragment).commit()
            }

        })


    }
}