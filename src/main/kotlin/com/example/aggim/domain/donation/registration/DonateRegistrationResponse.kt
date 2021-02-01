package com.example.aggim.domain.donation.registration

data class DonateRegistrationResponse(
    var donationId: Long,
    var name: String,
    var goalVal: Int
)