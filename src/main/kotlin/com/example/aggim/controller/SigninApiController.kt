package com.example.aggim.controller

import com.example.aggim.common.ApiResponse
import com.example.aggim.domain.auth.JWTUtil
import com.example.aggim.domain.auth.SigninRequest
import com.example.aggim.domain.auth.SigninService
import com.example.aggim.domain.auth.UserContextHolder
import com.example.aggim.interceptor.TokenValidationInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/*
    Created by Seohyun Kim at 2021/01/22
 */

@RestController
@RequestMapping("/api/v1")
class SigninApiController @Autowired constructor(
    private val signinService: SigninService,
    private val userContextHolder: UserContextHolder
) {
    @PostMapping("/signin")
    fun signin(@RequestBody signinRequest: SigninRequest) =
        ApiResponse.ok(signinService.signin(signinRequest)

        )

    @PostMapping("/refresh_token")
    fun refreshToken(
        @RequestParam("grant_type") grantType: String
    ): ApiResponse {
        if (grantType != TokenValidationInterceptor.GRANT_TYPE_REFRESH) {
            throw IllegalArgumentException("grant_type 없음")
        }

        return userContextHolder.email?.let {
            ApiResponse.ok(JWTUtil.createToken(it))
        } ?: throw IllegalArgumentException("사용자 정보 없음")
    }
}