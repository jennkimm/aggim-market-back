package com.example.aggim.domain.product

import com.example.aggim.domain.donation.Donate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Pageable

interface ProductRepository : JpaRepository<Product, Long> {
    fun findByIdIn(productIds: List<Long>): MutableList<Product>

    override fun getOne(productId: Long): Product

    fun findByCategoryIdAndIdGreaterThanOrderByIdDesc(
        categoryId: Int?, id: Long, pageable: Pageable
    ): List<Product>

    fun findByCategoryIdAndIdLessThanOrderByIdDesc(
        categoryId: Int?, id: Long, pageable: Pageable
    ): List<Product>

    fun findByIdGreaterThanAndNameLikeOrderByIdDesc(
        id: Long, keyword: String, pageable: Pageable
    ): List<Product>

    fun findByIdLessThanAndNameLikeOrderByIdDesc(
        id: Long, keyword: String, pageable: Pageable
    ): List<Product>

}