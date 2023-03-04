package com.example.backendpracticas.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name= "customer")
class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var firstname: String? = null
    var lastname: String? = null
    var nui: String? = null
    @NotBlank
    var email: String? = null
    var phone: String? = null
    var age: Long? = null
    @Column(name = "category_id")
    var categoryId: Long? = null
}