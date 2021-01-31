package com.example.aggim.domain.donation.registration

import com.example.aggim.common.AggimException
import com.example.aggim.domain.auth.UserContextHolder
import com.example.aggim.domain.donation.Donate
import com.example.aggim.domain.donation.DonateRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class DonateRegistrationService  @Autowired constructor(
    private val userContextHolder: UserContextHolder,
    private val donateRepository: DonateRepository
) {
    fun registerDonate(request: DonateRegistrationRequest) =
        userContextHolder.id?.let { userId ->
            donateRepository.save(Donate(request.donatedVal, userId, request.donationId))
        } ?: throw AggimException(
            "기부에 실패했습니다."
        )
}
