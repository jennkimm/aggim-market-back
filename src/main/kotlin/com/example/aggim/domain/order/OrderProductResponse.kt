package com.example.aggim.domain.order

import com.example.aggim.domain.product.Product

data class OrderProductResponse(
    val id: Long,
    val product_id: Long,
    val order_id: Long
//    val product: Product,
//    val order: Order
//    val productId: Long,
//    val orderId: Long
)

fun OrderProduct.toOrderProductResponse() = id?.let {
    OrderProductResponse(
        it,
        product_id,
        order_id
//        product!!,
//        order!!
//        product?.id ?: -1,
//        order?.id ?: -1
    )
}