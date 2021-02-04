package com.example.aggim.domain.order

import com.example.aggim.domain.jpa.BaseEntity
import com.example.aggim.domain.product.Product
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity(name="orders")
data class Order (
    @Column(length = 40)
    var name: String,
    val userId: Long,
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    var products: MutableList<Product>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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