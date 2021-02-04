package com.example.aggim.domain.order

import com.example.aggim.domain.product.Product

data class OrderRequest(
    val productIds: List<Long?>,
    val name: String
)