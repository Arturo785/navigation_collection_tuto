package com.example.navigationcollectiontuto

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val args : LoginFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameDeepLink = args.username
        textLayoutUsername.editText?.setText(usernameDeepLink)


        btnDoLogin.setOnClickListener {

            val username = textLayoutUsername.editText?.text.toString()
            val password = textLayoutPassword.editText?.text.toString()

            //Have to rebuild project if first time adding the view
            val option = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username,password)
            findNavController().navigate(option)
        }

    }


}