package com.example.aggim.domain.donation

import javax.persistence.*

@Entity(name="donate")
data class Donate(
    var donatedVal: Int,
    var userId: Long,
    @OneToOne
    var donation: Donation ?= null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}