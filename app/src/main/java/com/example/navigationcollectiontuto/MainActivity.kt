package com.example.navigationcollectiontuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navControler : NavController

    private lateinit var appBarConfiguration : AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This is just because DayNight theme uses the darkMode of the system and
        //Because I don't want to configure the theme I just made it lightTheme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        //This is needed for the toolBar management
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navControler = navHostFragment.findNavController()

        //Sets the top level destinations to not show the arrow back button
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.searchFragment)
        )

        setSupportActionBar(toolBar)
        setupActionBarWithNavController(navControler, appBarConfiguration)

        // connects the nav_bar with the navigation
        bottom_nav.setupWithNavController(navControler)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navControler.navigateUp() || super.onSupportNavigateUp()
    }

    //The menu we created
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // the global action set of the nav_graph
        //This way we can send data and also animations
        return if (item. itemId == R.id.termsAndConditions){
            val action = NavGraphDirections.actionGlobalTermsFragment()
            navControler.navigate(action)
            true
        }
        else {
            item.onNavDestinationSelected(navControler) || super.onOptionsItemSelected(item)
            // navigates to the destination we clicked
            //Destination has to have the same name as the id of the option
        }
    }
}