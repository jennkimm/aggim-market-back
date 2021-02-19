package com.example.aggim.domain.product

import com.example.aggim.domain.order.Order
import com.example.aggim.domain.order.OrderProduct
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "product")
class Product(
    @Column(length = 40)
    var name: String,
    @Column(length = 500)
    var description: String,
    var price: Int,
    var categoryId: Int,
    @Enumerated(EnumType.STRING)
    var status: ProductStatus,
    @OneToMany
    @JoinColumn(name = "productId")
    var images: MutableList<ProductImage>,
    val userId: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    var id: Long? = null

//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    lateinit var orderProducts: MutableList<OrderProduct>
}
