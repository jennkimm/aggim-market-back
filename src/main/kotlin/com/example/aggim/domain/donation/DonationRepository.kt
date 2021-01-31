package com.example.aggim.domain.donation

import com.example.aggim.domain.product.Product
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface DonationRepository : JpaRepository<Donation, Long> {
    fun findByIdGreaterThanAndNameLikeOrderByIdDesc(
        id: Long, keyword: String, pageable: Pageable
    ): List<Donation>

    fun findByIdLessThanAndNameLikeOrderByIdDesc(
        id: Long, keyword: String, pageable: Pageable
    ): List<Donation>
}