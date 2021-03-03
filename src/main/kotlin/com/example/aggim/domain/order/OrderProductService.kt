package com.example.aggim.domain.order

import com.example.aggim.AggimApplication
import com.example.aggim.common.AggimException
import com.example.aggim.domain.auth.UserContextHolder
import com.example.aggim.domain.product.Product
import com.example.aggim.domain.product.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OrderProductService @Autowired constructor(
    private val orderProductRepository: OrderProductRepository,
    private val productService: ProductService,
    private val orderService : OrderService
){
    fun getO() = orderProductRepository.findAll()

    fun getOr(orderId: Long) = orderProductRepository.findByOrderId(orderId).let{
        print("hihiplease")
    }

    fun register(request: OrderProductRequest) {
        val product = productService.get(request.productId)
            ?: throw AggimException("상품 정보를 찾을 수 없습니다.")

        val order = request.orderId?.let { orderService.get(it) }
            ?: throw AggimException("주문 정보를 찾을 수 없습니다.")

        val orderProduct = saveOrderProduct(request, order, product)

//        return orderProduct.id?.let {
//            OrderProductResponse(it, order)
//        }
    }

    private fun saveOrderProduct(request: OrderProductRequest, order: Order, product: Product) : OrderProduct {
        val orderProduct = OrderProduct(request.productId, request.orderId)
        return orderProductRepository.save(orderProduct)
    }
}