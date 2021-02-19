package com.example.aggim.domain.order

import com.example.aggim.domain.product.Product
import javax.persistence.*

@Entity(name="order_product")
class OrderProduct(
    val product_id: Long,
    val order_id: Long
    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_product_id")
    open var id: Long? = null

    @ManyToOne
    @JoinColumn(name="product_id", insertable = false, updatable = false)
    var product: Product?=null
//
//    @ManyToOne
//    @JoinColumn(name="order_id", insertable = false, updatable = false)
//    var order: Order?=null
}