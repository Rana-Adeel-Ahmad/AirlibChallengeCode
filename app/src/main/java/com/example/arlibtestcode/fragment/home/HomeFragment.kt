package com.example.arlibtestcode.fragment.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.arlibtestcode.fragment.home.screen.HomeScreen
import com.example.arlibtestcode.ui.theme.ArlibTestCodeTheme
import com.example.arlibtestcode.viewmodel.HomeViewModel

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    email: String? = null,
    onClickToDetailScreen: (String, String, String) -> Unit = { s: String, s1: String, s2: String -> }
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val medicineList by homeViewModel.medicineListState.observeAsState()
        HomeScreen(
            modifier = Modifier.padding(16.dp),
            medicineList = medicineList,
            email = email,
            onClickToDetailScreen = onClickToDetailScreen
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeFragmentPreview() {
    ArlibTestCodeTheme {
        HomeFragment()
    }
}