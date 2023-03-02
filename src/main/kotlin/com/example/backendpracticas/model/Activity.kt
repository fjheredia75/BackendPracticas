package com.example.backendpracticas.model

import java.util.Date
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank


class Activity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    @NotBlank
    var fecha: Date? = null
    @Column(name = "oportunity_id")
    var oportunityId: Long? = null
}