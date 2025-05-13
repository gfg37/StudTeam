package com.example.StudTeamServer.controller

import com.example.StudTeamServer.dto.ProjectRequestDTO
import com.example.StudTeamServer.entity.Project
import com.example.StudTeamServer.service.ProjectService
import com.example.StudTeamServer.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/projects")
class ProjectController(
    private val projectService: ProjectService,
    private val userService: UserService
){
    @GetMapping
    fun getAllProjects():List<Project> =
    projectService.getAllProjects()


    @PostMapping
    fun createProject(@RequestBody request: ProjectRequestDTO): Project =
        projectService.createProject(request)

}

