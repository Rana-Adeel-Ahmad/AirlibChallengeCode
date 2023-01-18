package com.example.arlibtestcode.domain.repositery

import com.example.arlibtestcode.domain.model.MedicineResponse

interface MedicineRepositery {
    suspend fun getAllMedicine(): MedicineResponse
}