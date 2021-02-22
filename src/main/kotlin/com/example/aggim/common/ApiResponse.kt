package com.example.aggim.common

/*
    Created by Seohyun Kim at 2021/01/20
 */

data class
ApiResponse(
    val success: Boolean,
    val data: Any? = null,
    val message: String? = null
) {

    companion object {
        fun ok(data: Any? = null) = ApiResponse(true, data)
        fun error(message: String? = null) =
            ApiResponse(false, message = message)
    }

}