package com.example.aggim.domain.auth

/*
    Created by Seohyun Kim at 2021/01/22
 */

data class SigninResponse(
    val token: String,
    val refreshToken: String,
    val userName: String,
    val userId: Long,
    val email: String
)