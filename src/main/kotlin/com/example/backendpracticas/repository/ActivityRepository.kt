package com.example.backendpracticas.repository

import com.example.backendpracticas.model.Activity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ActivityRepository: JpaRepository<Activity, Long?> {
    fun findById(id: Long?): Activity?
}
