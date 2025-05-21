package com.example.StudTeamServer.repository
import com.example.StudTeamServer.entity.ProjectApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository



@Repository
interface ProjectApplicationRepository : JpaRepository<ProjectApplication, Long>{

}