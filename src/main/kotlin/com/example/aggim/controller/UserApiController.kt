package com.example.aggim.controller

import com.example.aggim.common.ApiResponse
import com.example.aggim.domain.auth.SignupRequest
import com.example.aggim.domain.auth.SignupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/*
    Created by Seohyun Kim at 2021/01/21
 */

@RestController
@RequestMapping("/api/v1")
class UserApiController @Autowired constructor(
    private val signupService: SignupService
){
    @PostMapping("/users")
    fun signup(@RequestBody signupRequest: SignupRequest) =
        ApiResponse.ok(signupService.signup(signupRequest))
}