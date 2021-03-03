package com.example.aggim.domain.order

import com.example.aggim.domain.jpa.BaseEntity
import com.example.aggim.domain.product.Product
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity(name="orders")
class Order (
    @Column(length = 40)
    var name: String,
    val userId: Long,
    @OneToMany
    @JoinColumn(name="orderId")
    var orderProducts: MutableList<OrderProduct>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    open var id: Long? = null

    open var createdAt: Date? = null
    open var updatedAt: Date? = null

    @PrePersist
    fun prePersist() {
        createdAt = Date()
        updatedAt = Date()
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = Date()
    }
}