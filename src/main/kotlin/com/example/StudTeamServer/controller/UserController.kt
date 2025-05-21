package com.example.StudTeamServer.controller


import com.example.StudTeamServer.dto.AuthenticationRequest
import com.example.StudTeamServer.dto.UserProfileDTO
import com.example.StudTeamServer.entity.User
import com.example.StudTeamServer.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAllUsers(): List<User> =
        userService.getAllUsers()

    @GetMapping("/id/{id}")
    fun getUserById(@PathVariable id: Long): User? =
        userService.getUserById(id)

    @GetMapping("/email/{email}")
    fun getUserByEmail(@PathVariable email: String): User? =
        userService.findUserByEmail(email)

    @PostMapping
    fun createUser(@RequestBody user: User): User =
        userService.createUser(user)

    @PostMapping("/authenticate")
    fun authenticate(@RequestBody auth: AuthenticationRequest): ResponseEntity<User> {
        val user = userService.authenticate(auth.email, auth.password)
        return ResponseEntity.ok(user)
    }

    @GetMapping("/profile/{id}")
    fun getUserProfile(@PathVariable id: Long): UserProfileDTO {
        return userService.getUserProfile(id)
    }


}

