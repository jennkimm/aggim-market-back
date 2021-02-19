package com.example.aggim.domain.order

data class OrderProductRequest (
    val orderId: Long,
    val productId: Long
)