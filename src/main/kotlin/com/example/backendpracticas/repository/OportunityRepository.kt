package com.example.backendpracticas.repository

import com.example.backendpracticas.model.Oportunity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface OportunityRepository: JpaRepository<Oportunity, Long?> {
    fun findById(id: Long?): Oportunity?
}
