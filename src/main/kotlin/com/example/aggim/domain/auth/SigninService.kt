package com.example.aggim.domain.auth

import com.example.aggim.common.AggimException
import com.example.aggim.domain.user.User
import com.example.aggim.domain.user.UserRepository
import org.mindrot.jbcrypt.BCrypt
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

@Service
class SigninService @Autowired constructor(
    private val userRepository: UserRepository
) {

    fun signin(signinRequest: SigninRequest): SigninResponse {
        val user = userRepository
            .findByEmail(signinRequest.email.toLowerCase())
            ?: throw AggimException("로그인 정보를 확인해주세요.")

        if (isNotValidPassword(signinRequest.password, user.password)) {
            throw AggimException("비밀번호가 올바르지 않습니다.")
        }

        return responseWithTokens(user)
    }

    private fun isNotValidPassword(
        plain: String,
        hashed: String
    ) = BCrypt.checkpw(plain, hashed).not()

    private fun responseWithTokens(user: User) = user.id?.let { userId ->
        SigninResponse(
            JWTUtil.createToken(user.email),
            JWTUtil.createRefreshToken(user.email),
            user.name,
            userId
        )
    } ?: throw IllegalStateException("user.id 없음.")

}