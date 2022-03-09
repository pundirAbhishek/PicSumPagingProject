package com.example.picsumproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.picsumproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            // Let's first dynamically add a fragment into a frame container
            supportFragmentManager.beginTransaction()
                .replace(R.id.picSumFragment, PicSumFragment(), "PicSumFragment").commit()
        }
    }

    fun switchContent(fragment: Fragment) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.picSumFragment, fragment, fragment.toString())
        ft.addToBackStack(null)
        ft.commit()
    }
}