package com.example.aggim.domain.donation.registration

data class DonationRegistrationRequest(
    val name: String,
    val goalVal: Int,
    val donateIds: List<Long?>
)