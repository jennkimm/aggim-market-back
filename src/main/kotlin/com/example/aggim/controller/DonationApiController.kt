package com.example.aggim.controller

import com.example.aggim.common.ApiResponse
import com.example.aggim.domain.donation.registration.DonateRegistrationRequest
import com.example.aggim.domain.donation.registration.DonateRegistrationService
import com.example.aggim.domain.donation.registration.DonationRegistrationRequest
import com.example.aggim.domain.donation.registration.DonationRegistrationService
import com.example.aggim.domain.product.registration.ProductRegistrationRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1")
class DonationApiController @Autowired constructor(
    private val donateRegistrationService: DonateRegistrationService,
    private val donationRegistration: DonationRegistrationService,
    private val donateRegistration: DonateRegistrationService
) {
    @PostMapping("/donates")
    fun registerDonate(
        @RequestBody request: DonateRegistrationRequest
    ) = ApiResponse.ok(donateRegistration.registerDonate(request))

    @PostMapping("/donations")
    fun register(
        @RequestBody request: DonationRegistrationRequest
    ) = ApiResponse.ok(donationRegistration.register(request))
}