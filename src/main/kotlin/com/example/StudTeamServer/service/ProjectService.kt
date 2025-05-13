package com.example.StudTeamServer.service

import com.example.StudTeamServer.dto.ProjectRequestDTO
import com.example.StudTeamServer.entity.Project
import com.example.StudTeamServer.entity.User
import com.example.StudTeamServer.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class ProjectService(
    private val projectRepository: ProjectRepository,
    private val userService: UserService
) {
    fun getAllProjects(): List<Project> =
        projectRepository.findAll()

    fun createProject(request: ProjectRequestDTO): Project {
        val owner: User = userService.getUserById(request.ownerId)
            ?: throw RuntimeException("User not found")

        val project = Project(
            title = request.title,
            description = request.description,
            goals = request.goals,
            requirements = request.requirements,
            created_at = request.createdAt,
            owner = owner
        )

        return projectRepository.save(project)
    }
}


