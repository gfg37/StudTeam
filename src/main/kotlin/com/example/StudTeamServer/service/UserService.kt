package com.example.StudTeamServer.service


import com.example.StudTeamServer.entity.User
import com.example.StudTeamServer.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> =
        userRepository.findAll()

    fun getUserById(id: Long): User? =
        userRepository.findById(id).orElse(null)

    fun createUser(user: User): User =
        userRepository.save(user)

    fun findUserByEmail(email: String): User? =
        userRepository.findByEmail(email)



    fun authenticate(email: String, password: String): User {
        val user = userRepository.findByEmail(email)
            ?: throw RuntimeException("Пользователь не найден")
        if (user.password != password) throw RuntimeException("Неверный пароль")
        return user
    }


}
