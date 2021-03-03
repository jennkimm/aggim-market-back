package com.example.aggim.domain.order

import org.springframework.data.jpa.repository.JpaRepository

interface OrderProductRepository : JpaRepository<OrderProduct, Long> {
    fun findByIdIn(orderProductIds: List<Long>) : MutableList<OrderProduct>

    fun findByOrderId(orderId: Long) : MutableList<OrderProduct>
}