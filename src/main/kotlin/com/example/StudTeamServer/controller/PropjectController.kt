package com.example.StudTeamServer.controller

import com.example.StudTeamServer.entity.Project
import com.example.StudTeamServer.service.ProjectService
import com.example.StudTeamServer.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/projects")
class ProjectController(
    private val projectService: ProjectService,
    private val userService: UserService
){
    @GetMapping
    fun getProjects() : List<Project> =
        projectService.getAllprojects()
}