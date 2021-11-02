package com.example.kotlin_exercise.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.kotlin_exercise.R
import com.example.kotlin_exercise.data.Project

class ProjectDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment/
        return inflater.inflate(R.layout.fragment_project_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val title = view.findViewById<TextView>(R.id.projectTitle)
        val description = view.findViewById<TextView>(R.id.projectDescription)
        val image = view.findViewById<ImageView>(R.id.projectImage)
        val button = view.findViewById<Button>(R.id.backBtn)

        val project: Project = arguments?.getSerializable("project") as Project

        (activity as AppCompatActivity).supportActionBar?.title = project.projectName

        title.text = project.projectName
        description.text = project.projectDescription
        image.setImageResource(project.projectImage)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        button.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
    }
}