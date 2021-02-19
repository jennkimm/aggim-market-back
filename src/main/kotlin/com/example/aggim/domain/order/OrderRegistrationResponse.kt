package com.example.aggim.domain.order

import com.example.aggim.domain.product.Product

data class OrderRegistrationResponse(
    var productId: List<Long>,
    var name: String,
    var products: MutableList<Product>
)