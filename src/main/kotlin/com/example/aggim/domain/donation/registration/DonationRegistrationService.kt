package com.example.aggim.domain.donation.registration

import com.example.aggim.common.AggimException
import com.example.aggim.domain.auth.UserContextHolder
import com.example.aggim.domain.donation.DonateRepository
import com.example.aggim.domain.donation.Donation
import com.example.aggim.domain.donation.DonationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DonationRegistrationService  @Autowired constructor(
    private val DonationRepository: DonationRepository,
    private val donateRepository: DonateRepository,
    private val userContextHolder: UserContextHolder
    ) {
    fun register(request: DonationRegistrationRequest) =
        DonationRepository.save(Donation(request.name, request.goalVal))
////        userContextHolder.id?.let { userId ->
////            val donations by lazy { findAndValidateDonates(request.donationIds) }
//            request.toDonation(donations)
//                .run(::save)
////        } ?: throw AggimException(
//            "기부 등록에 필요한 사용자 정보가 존재하지 않습니다."
//        )
//
//    private fun findAndValidateDonates(donationIds: List<Long?>) =
//        DonationRepository.findByIdIn(donationIds.filterNotNull())
//            .also { donates ->
//                donates.forEach { donation ->
//                    if (donation.id != null)
//                        throw AggimException("이미 등록된 기부처입니다.")
//                }
//            }

    private fun save(donation: Donation) = DonationRepository.save(donation)
}

private fun DonationRegistrationRequest.validateRequest() = when {
    name.length !in 1..45 ||
            goalVal <= 0 ->
        throw AggimException("올바르지 않은 기부 정보입니다")
    else -> {
    }
}

private fun DonationRegistrationRequest.toDonation(
    donations: MutableList<Donation>
)=Donation(
    name,
    goalVal
//    donations
)