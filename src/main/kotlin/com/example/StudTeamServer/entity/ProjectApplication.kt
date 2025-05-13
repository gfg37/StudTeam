package com.example.StudTeamServer.entity

import jakarta.persistence.*

@Entity
@Table(name = "project_applications")
data class ProjectApplication(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    val project: Project,

    @ManyToOne
    @JoinColumn(name = "applicant_id", nullable = false)
    val applicant: User,

    @Column(nullable = false)
    var status: String = "PENDING" // Возможные значения: PENDING, ACCEPTED, REJECTED
)