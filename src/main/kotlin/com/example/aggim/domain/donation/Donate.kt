package com.example.aggim.domain.donation

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name="donate")
class Donate(
    var donatedVal: Int,
    var userId: Long,
    var donationId:Long ?= null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}