package com.example.aggim.domain.auth

import com.example.aggim.common.AggimException
import com.example.aggim.domain.user.User
import com.example.aggim.domain.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.mindrot.jbcrypt.BCrypt

@Service
class SignupService @Autowired constructor(
    private val userRepository: UserRepository
) {
    fun signup(signupRequest: SignupRequest) {
        validateRequest(signupRequest)
        checkDuplicates(signupRequest.email)
        registerUser(signupRequest)
    }

    private fun validateRequest(signupRequest: SignupRequest) {
        validateEmail(signupRequest.email)
        validateName(signupRequest.name)
        validatePassword(signupRequest.password)
    }

    private fun validatePassword(password: String) {
        if (password.trim().length !in 8..20)
            throw AggimException("비밀번호는 공백을 제외하고 8자 이상 20자 이하여야 합니다.")
    }

    private fun validateName(name: String) {
        if (name.trim().length !in 2..20)
            throw AggimException("이름은 2자 이상 20자 이하여야 합니다.")
    }

    private fun registerUser(signupRequest: SignupRequest) {
        with(signupRequest) {
            val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
            val user = User(email, hashedPassword, name)
            userRepository.save(user)
        }
    }

    private fun checkDuplicates(email: String) {
        userRepository.findByEmail(email)?.let {
            throw AggimException("이미 사용 중인 이메일입니다.")
        }
    }

    private fun validateEmail(email: String) {
        val isNotValidEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
            .toRegex(RegexOption.IGNORE_CASE)
            .matches(email)
            .not()

        if (isNotValidEmail) {
            throw AggimException("이메일 형식이 올바르지 않습니다.")
        }
    }
}