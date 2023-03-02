package com.example.backendpracticas.model

import java.util.*
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

class Oportunity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    @NotBlank
    var fecha_inicio: Date? = null
    var fecha_fin: Date? = null
    @Column(name = "customer_id")
    var customerId: Long? = null
}