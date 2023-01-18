package com.example.arlibtestcode.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arlibtestcode.ui.theme.ArlibTestCodeTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    name: String = "",
    dose: String = "",
    strength: String = "",
    onClickProduct: () -> Unit = {},
) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize(200f),
        onClick = onClickProduct,
        elevation = 10.dp
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = dose,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 8.sp,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = strength,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 8.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    ArlibTestCodeTheme {
        ProductCard()
    }
}