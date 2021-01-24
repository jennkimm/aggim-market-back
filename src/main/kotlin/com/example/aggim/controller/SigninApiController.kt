package com.example.aggim.controller

import com.example.aggim.common.ApiResponse
import com.example.aggim.domain.auth.SigninRequest
import com.example.aggim.domain.auth.SigninService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/*
    Created by Seohyun Kim at 2021/01/22
 */

@RestController
@RequestMapping("/api/v1")
class SigninApiController @Autowired constructor(
    private val signinService: SigninService
) {
    @PostMapping("/signin")
    fun signin(@RequestBody signinRequest: SigninRequest) =
        ApiResponse.ok(signinService.signin(signinRequest))
}