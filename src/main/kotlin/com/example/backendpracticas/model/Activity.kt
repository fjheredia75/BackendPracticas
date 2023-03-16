package com.example.backendpracticas.model

import java.util.Date
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table( name="activity")
class Activity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    var fecha: Date? = null
    @Column(name = "oportunity_id")
    var oportunityId: Long? = null
}