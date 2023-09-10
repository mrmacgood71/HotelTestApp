package it.macgood.hotelapp.domain.model

import java.util.concurrent.atomic.AtomicInteger

data class Tourist(
    val id: Int,
    val firstname: String = "",
    val lastname: String = "",
    val dateOfBirth: String = "",
    val citizenship: String = "",
    val foreignPassportNumber: String = "",
    val foreignPassportValidityPeriod: String = ""
)