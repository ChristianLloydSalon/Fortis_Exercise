package com.example.kotlin_exercise.data

import java.io.Serializable

data class Project(private val name: String, private val description: String, private val image: Int): Serializable {
    val projectName: String get() = name
    val projectDescription: String get() = description
    val projectImage: Int get() = image
}
