package com.example.StudTeamServer.dto

import jakarta.validation.constraints.Email

data class AuthenticationRequest(
    val email: String,
    val password: String
)
