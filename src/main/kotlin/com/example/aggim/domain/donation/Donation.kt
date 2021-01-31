package com.example.aggim.domain.donation

import javax.persistence.*

@Entity(name="donation")
class Donation(
    var name: String,
    var goalVal: Int,
    @OneToMany
    @JoinColumn(name="donationId")
    var donates: MutableList<Donate>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}