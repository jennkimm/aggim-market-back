package com.example.aggim.domain.order

import com.example.aggim.common.AggimException
import com.example.aggim.domain.product.Product

data class OrderResponse(
    val id: Long,
    val name: String,
    val userId: Long
)

fun Order.toOrderResponse() = id?.let {
    OrderResponse(
        it,
        name,
        userId
    )
} ?: throw AggimException("주문 정보를 찾을 수 없습니다.")