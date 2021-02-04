package com.example.aggim.domain.donate

import com.example.aggim.common.AggimException
import com.example.aggim.domain.donation.Donate
import com.example.aggim.domain.donation.Donation

data class DonateResponse(
    var donatedVal: Int,
    var userId: Long,
    var donation: Donation?
)

fun Donate.toDonateResponse() = let{
    DonateResponse(
        donatedVal,
        userId,
        donation
    )
} ?: throw AggimException("기부 정보를 찾을 수 없습니다.")