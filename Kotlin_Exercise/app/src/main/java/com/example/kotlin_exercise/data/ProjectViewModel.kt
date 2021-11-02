package com.example.kotlin_exercise.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProjectViewModel: ViewModel() {
    var currentProject: Project? = null

    private val projectsLiveData = MutableLiveData<MutableList<Project>>()
    private val projectList = mutableListOf<Project>()

    fun getProjects(): MutableLiveData<MutableList<Project>> {
        return projectsLiveData
    }

    fun addProject(project: Project) {
        projectList.add(project)
        projectsLiveData.value = projectList
    }

    fun removeProject(project: Project) {
        projectList.remove(project)
        projectsLiveData.value = projectList
    }
}