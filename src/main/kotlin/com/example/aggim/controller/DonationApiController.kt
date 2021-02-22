package com.example.aggim.controller

import com.example.aggim.common.AggimException
import com.example.aggim.common.ApiResponse
import com.example.aggim.domain.donate.DonateResponse
import com.example.aggim.domain.donate.toDonateResponse
import com.example.aggim.domain.donation.Donate
import com.example.aggim.domain.donation.DonateRepository
import com.example.aggim.domain.donation.DonateService
import com.example.aggim.domain.donation.DonationService
import com.example.aggim.domain.donation.registration.*
import com.example.aggim.domain.product.Product
import com.example.aggim.domain.product.ProductService
import com.example.aggim.domain.product.registration.ProductRegistrationRequest
import com.example.aggim.domain.product.toProductResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1")
class DonationApiController @Autowired constructor(
    private val donationRegistration: DonationRegistrationService,
    private val donateRegistration: DonateRegistrationService,
    private val donateService: DonateService,
    private val donationService: DonationService
) {
    @PostMapping("/donates")
    fun registerDonate(
        @RequestBody request: DonateRegistrationRequest
    ) = ApiResponse.ok(donateRegistration.registerDonate(request))

    @GetMapping("/donates")
    fun get() = donateService.get()?.let{
        ApiResponse.ok(it)
    } ?: throw AggimException("기부 정보를 찾을 수 없습니다.")

    @PostMapping("/donations")
    fun register(
        @RequestBody request: DonationRegistrationRequest
    ) = ApiResponse.ok(donationRegistration.register(request))

    @GetMapping("/donations")
    fun getDonations() = donationService.get()?.let {
        ApiResponse.ok(it)
    } ?: throw AggimException("기부처 정보를 찾을 수 없습니다.")
}