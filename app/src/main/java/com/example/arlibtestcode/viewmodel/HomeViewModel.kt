package com.example.arlibtestcode.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.arlibtestcode.domain.model.Medicine
import com.example.arlibtestcode.domain.repositery.MedicineRepositery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val medicineRepositery: MedicineRepositery
) : ViewModel(){

    var medicineListState = liveData<List<Medicine>>(Dispatchers.IO) {
        medicineRepositery.getAllMedicine().drugs?.let { this.emit(it) }
    }
}