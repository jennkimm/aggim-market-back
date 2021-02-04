package com.example.aggim.domain.donation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DonateService @Autowired constructor(
    private val donateRepository: DonateRepository
) {
    fun get() = donateRepository.findAll()
}