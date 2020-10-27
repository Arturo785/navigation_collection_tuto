package com.example.navigationcollectiontuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navControler : NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This is just because DayNight theme uses the darkMode of the system and
        //Because I don't want to configure the theme I just made it lightTheme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        //This is needed for the toolBar management
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navControler = navHostFragment.findNavController()

        setSupportActionBar(toolBar)
        setupActionBarWithNavController(navControler)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navControler.navigateUp() || super.onSupportNavigateUp()
    }
}