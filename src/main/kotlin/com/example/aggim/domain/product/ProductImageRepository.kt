package com.example.aggim.domain.product

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductImageRepository : JpaRepository<ProductImage, Long> {
    fun findByIdIn(imageIds: List<Long>): MutableList<ProductImage>

    override fun findById(imageId: Long): Optional<ProductImage>
}