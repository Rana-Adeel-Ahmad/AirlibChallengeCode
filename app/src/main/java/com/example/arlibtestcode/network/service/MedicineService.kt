package com.example.arlibtestcode.network.service

import com.example.arlibtestcode.domain.model.MedicineResponse
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface MedicineService {

    @POST("b09cb6fd-f16e-4a4a-9f95-d341a8f1b1b1")
    suspend fun getAllMedicine() : MedicineResponse
}