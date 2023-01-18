package com.example.arlibtestcode.domain.model

import com.google.gson.annotations.SerializedName

data class MedicineResponse(
    @field:SerializedName("associatedDrug")
    val drugs: List<Medicine>? = null,
)
data class Medicine(
    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("dose")
    val dose: String? = null,

    @field:SerializedName("strength")
    val strength: String? = null
)
