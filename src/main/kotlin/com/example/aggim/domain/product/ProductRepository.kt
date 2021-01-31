package com.example.aggim.domain.product

import com.example.aggim.domain.donation.Donate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Pageable

interface ProductRepository : JpaRepository<Product, Long> {
    fun findByCategoryIdAndIdGreaterThanOrderByIdDesc(
        categoryId: Int?, id: Long, pageable: Pageable
    ): List<Donate>

    fun findByCategoryIdAndIdLessThanOrderByIdDesc(
        categoryId: Int?, id: Long, pageable: Pageable
    ): List<Donate>

    fun findByIdGreaterThanAndNameLikeOrderByIdDesc(
        id: Long, keyword: String, pageable: Pageable
    ): List<Donate>

    fun findByIdLessThanAndNameLikeOrderByIdDesc(
        id: Long, keyword: String, pageable: Pageable
    ): List<Donate>

}