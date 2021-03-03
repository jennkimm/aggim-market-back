package com.example.aggim.controller

import com.example.aggim.common.AggimException
import com.example.aggim.common.ApiResponse
import com.example.aggim.domain.order.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class OrderApiController(
    private val orderService: OrderService,
    private val orderProductService: OrderProductService
) {
    @PostMapping("/order_products")
    fun register(
        @RequestBody request: OrderProductRequest
    ) = ApiResponse.ok(orderProductService.register(request))

    // 주문 목록을 가져
    @GetMapping("/orders")
    fun get() = ApiResponse.ok(orderService.getAll())

    @GetMapping("/order_products")
    fun getO() = ApiResponse.ok(orderProductService.getO())

//    @GetMapping("/order_products/{id}")
//    fun getOr(@PathVariable id: Long) = orderProductService.getOr(id)?.let {
//        print("herehere")
//        ApiResponse.ok(it)
//    } ?: throw AggimException("주문한 상품 정보를 찾을 수 없습니다.")

    // 주문 등록
    @PostMapping("/orders")
    fun register(
        @RequestBody request: OrderRequest
    ) = ApiResponse.ok(orderService.register(request))

//    @GetMapping("/orders")
//    fun get() = orderService.get()?.let{
//
//        ApiResponse.ok(it)
//    } ?: throw AggimException("주문 정보를 찾을 수 없습니다.")

//    @GetMapping("/orders/{id}")
//    fun get(@PathVariable id: Long) = orderService.get(id)?.let {
//        ApiResponse.ok(it)
//    } ?: throw AggimException("주문 정보를 찾을 수 없습니다.")
}