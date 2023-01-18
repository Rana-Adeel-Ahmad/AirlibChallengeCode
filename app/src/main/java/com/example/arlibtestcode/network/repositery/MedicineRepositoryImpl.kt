package com.example.arlibtestcode.network.repositery

import com.example.arlibtestcode.domain.model.MedicineResponse
import com.example.arlibtestcode.domain.repositery.MedicineRepositery
import com.example.arlibtestcode.network.service.MedicineService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MedicineRepositoryImpl @Inject constructor(
    val medicineService: MedicineService
): MedicineRepositery{

    override suspend fun getAllMedicine(): MedicineResponse = medicineService.getAllMedicine()
}