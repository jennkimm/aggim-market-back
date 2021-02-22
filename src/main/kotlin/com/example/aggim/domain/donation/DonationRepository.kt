package com.example.aggim.domain.donation

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DonationRepository : JpaRepository<Donation, Long> {
    override fun getOne(donationId: Long) : Donation
    fun findAllBy(): MutableList<Donation>
}