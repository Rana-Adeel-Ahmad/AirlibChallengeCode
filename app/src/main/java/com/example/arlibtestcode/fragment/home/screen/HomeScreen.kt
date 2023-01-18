package com.example.arlibtestcode.fragment.home.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.arlibtestcode.domain.model.Medicine
import com.example.arlibtestcode.ui.component.ProductCard
import com.example.arlibtestcode.util.Const.safeLet
import java.util.*

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    medicineList: List<Medicine>? = null,
    email: String? = null,
    onClickToDetailScreen: (String, String, String) -> Unit = { s: String, s1: String, s2: String -> },
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "${getGreetingMessage()}!\n\nWelcome to the app\n${email}",
            textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        medicineList?.let {
            LazyColumn(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                items(medicineList) { medicine ->
                    safeLet(
                        medicine.name,
                        medicine.dose,
                        medicine.strength
                    ) { name, dose, strength ->
                        ProductCard(
                            modifier = modifier.padding(8.dp),
                            name = name,
                            dose = dose,
                            strength = strength,
                            onClickProduct = {
                                onClickToDetailScreen.invoke(name, dose, strength)
                            }
                        )
                    }
                }
            }
        }
    }
}

fun getGreetingMessage(): String {
    val c = Calendar.getInstance()
    val timeOfDay = c.get(Calendar.HOUR_OF_DAY)

    return when (timeOfDay) {
        in 0..11 -> "Good Morning"
        in 12..15 -> "Good Afternoon"
        in 16..20 -> "Good Evening"
        in 21..23 -> "Good Night"
        else -> "Hello"
    }
}