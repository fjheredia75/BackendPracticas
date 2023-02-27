package com.example.backendpracticas.repository


import com.example.backendpracticas.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long?> {
    fun findById(id: Long?): Customer?
}