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
    private val productRepository: ProductRepository
) {
    fun get(id: Long) = orderRepository.findByIdOrNull(id)

    fun register(request: OrderRequest) =
        userContextHolder.id?.let { userId ->
            val products by lazy { findAndValidateProducts(request.productIds) }

            request.toOrder(products, userId)
                .run(::save)
        } ?: throw AggimException(
            "주문을 위한 사용자 정보가 존재하지 않습니다."
        )
    private fun findAndValidateProducts(productIds: List<Long?>) =
        productRepository.findByIdIn(productIds.filterNotNull())
//            .also { productss ->
//                for (ioi in productss) {
//                    ioi.id?.let { productRepository.getOne(it) }!!
//                }
//            }

    private fun save(order: Order) = orderRepository.save(order)
}

//private fun OrderRequest.validateRequest() {
//
//}

private fun OrderRequest.toOrder(
    products: MutableList<Product>,
    userId: Long
) = Order(
    name,
    userId,
    products
)