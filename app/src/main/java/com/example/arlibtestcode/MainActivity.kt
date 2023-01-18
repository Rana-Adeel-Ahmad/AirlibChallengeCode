package com.example.arlibtestcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.arlibtestcode.fragment.detail.DetailFragment
import com.example.arlibtestcode.fragment.home.HomeFragment
import com.example.arlibtestcode.fragment.login.LoginFragment
import com.example.arlibtestcode.ui.theme.ArlibTestCodeTheme
import com.example.arlibtestcode.util.Const
import com.example.arlibtestcode.util.Const.DETAIL_SCREEN_DOSE
import com.example.arlibtestcode.util.Const.DETAIL_SCREEN_NAME
import com.example.arlibtestcode.util.Const.DETAIL_SCREEN_STRENGTH
import com.example.arlibtestcode.util.Const.HOME_SCREEN_EMAIL
import com.example.arlibtestcode.util.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArlibTestCodeTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.Login.route) {
        composable(route = Route.Home.route) {
            HomeFragment(
                email = it.arguments?.getString(HOME_SCREEN_EMAIL),
                onClickToDetailScreen = { name, dose, strength ->
                    navController.navigate(
                        Route.Detail.createRoute(name, dose, strength)
                    )
                }
            )
        }
        composable(route = Route.Login.route) {
            LoginFragment(
                onClickToHomeScreen = { email ->
                    navController.navigate(
                        Route.Home.createRoute(email)
                    )
                }
            )
        }
        composable(
            route = Route.Detail.route,
            arguments = listOf(
                navArgument(Const.DETAIL_SCREEN_NAME) {
                    type = NavType.StringType
                },
                navArgument(Const.DETAIL_SCREEN_DOSE) {
                    type = NavType.StringType
                },
                navArgument(Const.DETAIL_SCREEN_STRENGTH) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString(DETAIL_SCREEN_NAME)
            val dose = backStackEntry.arguments?.getString(DETAIL_SCREEN_DOSE)
            val strength = backStackEntry.arguments?.getString(DETAIL_SCREEN_STRENGTH)
            requireNotNull(name) { "Name parameter wasn't found. Please make sure it's set!" }
            requireNotNull(dose) { "Dose parameter wasn't found. Please make sure it's set!" }
            requireNotNull(strength) { "Strength parameter wasn't found. Please make sure it's set!" }
            DetailFragment(name, dose, strength)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArlibTestCodeTheme {
        AppScreen()
    }
}