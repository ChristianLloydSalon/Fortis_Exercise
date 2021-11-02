package com.example.kotlin_exercise.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_exercise.R
import com.example.kotlin_exercise.data.Project
import com.example.kotlin_exercise.data.ProjectViewModel
import com.example.kotlin_exercise.data.RecyclerAdapter

class MainFragment : Fragment() {

    private val projects = listOf(
        Project("Tony Stark", "Iron Man", R.drawable.iron_man),
        Project("Steve Rogers", "Captain America", R.drawable.captain_america),
        Project("Thor Odinson", "God of Thunder", R.drawable.thor),
        Project("Natasha Romanoff", "Black Widow", R.drawable.black_widow)
    )

    private lateinit var viewModel: ProjectViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        viewModel = ViewModelProvider(this)[ProjectViewModel::class.java]

        for (project in projects) {
            viewModel.addProject(project)
            observe()
        }

        (activity as AppCompatActivity).supportActionBar?.title = "Main"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    private fun observe() {
        viewModel.getProjects().observe(viewLifecycleOwner, {
            recyclerView.adapter = RecyclerAdapter(it)
        })
    }
}