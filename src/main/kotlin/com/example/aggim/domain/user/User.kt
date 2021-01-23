package com.example.aggim.domain.user

import java.util.*
import javax.persistence.*

/*
    Created by Seohyun Kim at 2021/01/22
 */

@Entity(name = "user")
class User (
    var email: String,
    var password: String,
    var name: String
    )  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var createdAt: Date? = null
    var updatedAt: Date? = null

    @PrePersist
    fun prePersist() {
        createdAt = Date()
        updatedAt = Date()
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = Date()
    }
}