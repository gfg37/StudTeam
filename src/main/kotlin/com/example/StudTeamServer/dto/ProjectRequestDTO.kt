package com.example.StudTeamServer.dto

data class ProjectRequestDTO (
    val title: String,
    val description: String,
    val goals: String,
    val requirements: String,
    val createdAt: String,
    val ownerId: Long
    )

