package com.example.aggim.controller

import com.example.aggim.common.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/*
    Created by Seohyun Kim at 2021/01/20
 */

@RestController
class HelloApiController {
    @GetMapping("/api/v1/hello")
    fun hello() = ApiResponse.ok("world")
}