package com.example.aggim.domain.donation.registration

import com.example.aggim.common.AggimException
import com.example.aggim.domain.auth.UserContextHolder
import com.example.aggim.domain.donation.Donate
import com.example.aggim.domain.donation.DonateRepository
import com.example.aggim.domain.donation.Donation
import com.example.aggim.domain.donation.DonationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DonateRegistrationService  @Autowired constructor(
    private val userContextHolder: UserContextHolder,
    private val donateRepository: DonateRepository,
    private val donationRepository: DonationRepository
) {
    fun registerDonate(request: DonateRegistrationRequest)
            : DonateRegistrationResponse{
        userContextHolder.id?.let { userId ->
            val donation by lazy{ donationRepository.getOne(request.donationId) }
            request.toDonate(donation, userId)
                .run(::save)

            return donation.id?.let {
                DonateRegistrationResponse(it, donation.name, donation.goalVal)
            } ?: throw AggimException("기부처정보 저장 실패. 다시 시도해주세요.")
            //donateRepository.save(Donate(request.donatedVal, userId, donation))
        } ?: throw AggimException(
            "기부에 실패했습니다."
        )
    }

    private fun save(donate: Donate) = donateRepository.save(donate)

    private fun findAndValidateDonations(donationId: Long) =
        donationRepository.getOne(donationId)

}

private fun DonateRegistrationRequest.toDonate(
    donation: Donation,
    userId: Long
) = Donate(
    donatedVal,
    userId,
    donation
)