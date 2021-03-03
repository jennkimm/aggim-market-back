package com.example.aggim.domain.order

import com.example.aggim.domain.product.Product
import javax.persistence.*

@Entity(name="order_product")
class OrderProduct(
    val productId: Long,
    val orderId: Long
    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_product_id")
    open var id: Long? = null

    @ManyToOne
    @JoinColumn(name="productId", insertable = false, updatable = false)
    var product: Product?=null

//    @ManyToOne
//    @JoinColumn(name="orderId", insertable = false, updatable = false)
//    var order: Order?=null
}