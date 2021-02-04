package com.example.aggim.domain.order

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Pageable

interface OrderRepository : JpaRepository<Order, Long> {
//    fun findByProductIdLessThanOrderByIdDesc(
//        productIds: List<Long?>,
//        orderId: Long,
//        pageable: Pageable
//    ) : List<Order>
//
//    fun findByProductIdGreaterThanOrderByIdDesc(
//        productIds: List<Long?>,
//        orderId: Long,
//        pageable: Pageable
//    ) : List<Order>
}