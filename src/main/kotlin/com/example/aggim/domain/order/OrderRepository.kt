package com.example.aggim.domain.order

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Pageable

interface OrderRepository : JpaRepository<Order, Long> {
    fun findByUserIdLessThanOrderByIdDesc(
        userId: Long
    ) : List<Order>

    fun findByIdIn(orderId: Long): Order

}