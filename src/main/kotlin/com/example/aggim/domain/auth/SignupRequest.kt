package com.example.aggim.domain.auth

/*
    Created by Seohyun Kim at 2021/01/21
 */

data class SignupRequest(
    val email: String,
    val name: String,
    val password: String
)