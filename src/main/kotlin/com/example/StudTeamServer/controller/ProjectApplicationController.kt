package com.example.StudTeamServer.controller

import com.example.StudTeamServer.entity.ProjectApplication
import com.example.StudTeamServer.entity.User
import com.example.StudTeamServer.service.ProjectApplicationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/applications")
class ProjectApplicationController(
    private val projectApplicationService: ProjectApplicationService
) {
    @PostMapping("/{projectId}/apply/{userId}")
    fun applyToProject(
        @PathVariable projectId: Long,
        @PathVariable userId: Long
    ) = projectApplicationService.applyToProject(projectId, userId)

    @GetMapping("/project/{projectId}")
    fun getApplicationsByProjectId(@PathVariable projectId: Long) =
        projectApplicationService.getApplicationsByProjectId(projectId)


    @PutMapping("/review/{applicationId}")
    fun reviewApplication(
        @PathVariable applicationId: Long,
        @RequestParam accept: Boolean
    ): ProjectApplication {
        return projectApplicationService.reviewApplication(applicationId, accept)
    }

    @GetMapping("/project/{projectId}/accepted")
    fun getAcceptedApplicants(@PathVariable projectId: Long): List<User>{
        return projectApplicationService.getAcceptedApplicants(projectId)
    }

}
