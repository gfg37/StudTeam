package com.example.StudTeamServer.service

import com.example.StudTeamServer.entity.ProjectApplication
import com.example.StudTeamServer.entity.User
import com.example.StudTeamServer.repository.ProjectApplicationRepository
import com.example.StudTeamServer.repository.ProjectRepository
import com.example.StudTeamServer.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProjectApplicationService (
    private val applicationRepository: ProjectApplicationRepository,
    private val projectRepository: ProjectRepository,
    private val userRepository: UserRepository
) {
    fun getAcceptedApplicants(projectId: Long): List<User> {//Кто участвует в проекте
        val application = applicationRepository.findAll().filter { it.project.id == projectId && it.status == "ACCEPTED" }
        return application.map { it.applicant }
    }



    fun reviewApplication(applicationId: Long, accept: Boolean): ProjectApplication {//Принятие или отклонение заявки
        val optionalApplication = applicationRepository.findById(applicationId)

        val application = optionalApplication.orElseThrow { RuntimeException("Application not found") }
        application.status = if (accept) "ACCEPTED" else "REJECTED"

        return applicationRepository.save(application)
    }



    fun getApplicationsByProjectId(projectId: Long): List<ProjectApplication> { ///Получение всех откликов для влдаельца
        return applicationRepository.findAll().filter { application ->
            application.project.id == projectId
        }
    }



    fun applyToProject(projectId: Long, userId: Long): ProjectApplication { //создание отклика "вроде"
        val project = projectRepository.findById(projectId).orElse(null)
        if (project == null) {
            throw RuntimeException("Project not found")
        }

        val user = userRepository.findById(userId).orElse(null)
        if (user == null) {
            throw RuntimeException("User not found")
        }

        val application = ProjectApplication(project = project, applicant = user)

        return applicationRepository.save(application)

    }


}