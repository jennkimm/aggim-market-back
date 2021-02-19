package com.example.aggim.domain.order

import com.example.aggim.common.AggimException
import com.example.aggim.domain.auth.UserContextHolder
import com.example.aggim.domain.product.Product
import com.example.aggim.domain.product.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OrderService @Autowired constructor (
    private val orderRepository: OrderRepository,
    private val userContextHolder: UserContextHolder,
    private val orderProductRepository: OrderProductRepository,
    private val productRepository: OrderProductRepository
) {
    fun getAll() = orderRepository.findAll()

    fun get(id: Long) = orderRepository.findByIdOrNull(id)

    // 주문 등록 서비스
    fun register(request: OrderRequest) =
        // 일단 order 테이블에 주문 정보 자체를 등록 -> user  & name
        // orderproduct 테이블에 주문한 상품 정보를 등록
        userContextHolder.id?.let { userId ->
            val orderproducts by lazy { findAndValidateProducts(request.productIds) }
            request.toOrder(orderproducts, userId)
                .run(::save).let {
                    for(ioi in request.productIds) {
                        orderProductRepository.save(OrderProduct(ioi!!, it.id!!))
                    }
                }
        } ?: throw AggimException(
            "주문을 위한 사용자 정보가 존재하지 않습니다."
        )

    private fun findAndValidateProducts(orderProductIds: List<Long?>) =
        productRepository.findByIdIn(orderProductIds.filterNotNull())
//            .also { productss ->
//                for (ioi in productss) {
//                    ioi.id?.let { productRepository.getOne(it) }!!
//                }
//            }

    private fun save(order: Order) = orderRepository.save(order)
}

//private fun OrderRequest.validateRequest() {
//
//
private fun OrderRequest.toOrder(
    orderProducts: MutableList<OrderProduct>,
    userId: Long
) = Order(
    name,
    userId,
    orderProducts
)