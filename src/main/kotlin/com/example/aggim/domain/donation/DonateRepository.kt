package com.example.aggim.domain.donation

import com.example.aggim.domain.product.ProductImage
import org.springframework.data.jpa.repository.JpaRepository

interface DonateRepository : JpaRepository<Donate, Long> {
    fun findByIdIn(donateIds: List<Long>): MutableList<Donate>
}