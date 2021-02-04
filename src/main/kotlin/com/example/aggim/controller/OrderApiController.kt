package com.example.aggim.controller

import com.example.aggim.common.AggimException
import com.example.aggim.common.ApiResponse
import com.example.aggim.domain.order.OrderRequest
import com.example.aggim.domain.order.OrderService
import com.example.aggim.domain.order.toOrderResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class OrderApiController(
    private val orderService: OrderService
) {
    @PostMapping("/orders")
    fun register(
        @RequestBody request: OrderRequest
    ) = ApiResponse.ok(orderService.register(request))

    @GetMapping("/orders/{id}")
    fun get(@PathVariable id: Long) = orderService.get(id)?.let {
        ApiResponse.ok(it.toOrderResponse())
    } ?: throw AggimException("주문 정보를 찾을 수 없습니다.")
}