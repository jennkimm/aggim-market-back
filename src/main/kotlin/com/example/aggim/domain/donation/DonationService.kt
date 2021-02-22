package com.example.aggim.domain.donation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DonationService @Autowired constructor(
    private val donationRepository: DonationRepository
) {
    fun get() = donationRepository.findAllBy()
}