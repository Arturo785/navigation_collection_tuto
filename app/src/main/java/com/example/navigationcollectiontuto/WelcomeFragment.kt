package com.example.navigationcollectiontuto

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    // from safeArgs navigation
    private val args : WelcomeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //uses the safe args of navigation
        textViewUsername.text = args.userName
        textViewPassword.text = args.password

        btnGoHome.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment()

            findNavController().navigate(action)
            //To avoid retrieve the old stackNavigation (the back arrow leading to past fragments)
            // use popBehavior in navigation screen options and popUpToInclusive true

        }

    }

}