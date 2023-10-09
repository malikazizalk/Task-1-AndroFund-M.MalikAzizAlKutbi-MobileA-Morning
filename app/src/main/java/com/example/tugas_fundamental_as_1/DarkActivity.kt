package com.example.tugas_fundamental_as_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DarkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dark)

        val fragmenManager = supportFragmentManager //mengorganisiri suatu fragmen di dalam activity
        val homeFragment = HomeFragment()
        val fragment = fragmenManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment){
            fragmenManager
                .beginTransaction()
                .add(R.id.container, homeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }
    }
}