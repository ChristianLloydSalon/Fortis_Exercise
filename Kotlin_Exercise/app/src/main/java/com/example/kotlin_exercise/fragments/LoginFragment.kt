package com.example.kotlin_exercise.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.kotlin_exercise.R
import com.example.kotlin_exercise.data.Project
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_login, container, false)


        val button = view.findViewById<Button>(R.id.login)
        val username = view.findViewById<TextInputEditText>(R.id.username)
        val password = view.findViewById<TextInputEditText>(R.id.password)

        button.setOnClickListener {
            if (username.text.isNullOrEmpty() && password.text.isNullOrEmpty()) {
                Toast.makeText(context, "Fields should not be empty", Toast.LENGTH_SHORT).show()
            }
            else {
                val extras = Bundle()
                extras.putString("username", username.text.toString())
                findNavController().navigate(R.id.mainFragment)
            }
        }

        (activity as AppCompatActivity).supportActionBar?.title = "Login"

        return view
    }
}