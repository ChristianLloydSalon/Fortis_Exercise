package com.example.kotlin_exercise.data

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.findFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_exercise.R

class RecyclerAdapter(private val projects: List<Project>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_project, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(projects[position])

        holder.itemView.setOnClickListener {
            val extras = Bundle()
            extras.putSerializable("project", projects[position])
            findNavController(holder.itemView).navigate(R.id.projectDetailsFragment, extras)
        }
    }

    override fun getItemCount(): Int {
        return projects.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.projectImage)
        private val itemTitle: TextView = itemView.findViewById(R.id.projectTitle)
        private val itemDescription: TextView = itemView.findViewById(R.id.projectDescription)
        private val root by lazy { itemView.rootView }

        fun bind(project: Project) {
            itemTitle.text = project.projectName
            itemDescription.text = project.projectDescription
            itemImage.setImageResource(project.projectImage)
        }
    }
}