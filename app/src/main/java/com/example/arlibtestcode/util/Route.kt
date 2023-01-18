package com.example.arlibtestcode.util

import com.example.arlibtestcode.util.Const.DETAIL_SCREEN
import com.example.arlibtestcode.util.Const.DETAIL_SCREEN_DOSE
import com.example.arlibtestcode.util.Const.DETAIL_SCREEN_NAME
import com.example.arlibtestcode.util.Const.DETAIL_SCREEN_STRENGTH
import com.example.arlibtestcode.util.Const.HOME_SCREEN
import com.example.arlibtestcode.util.Const.HOME_SCREEN_EMAIL
import com.example.arlibtestcode.util.Const.LOGIN_SCREEN

sealed class Route(val route: String) {
    object Login: Route(LOGIN_SCREEN)
    object Home: Route("$HOME_SCREEN/{$HOME_SCREEN_EMAIL}"){
        fun createRoute(email: String) = "$HOME_SCREEN/$email"
    }
    object Detail: Route("$DETAIL_SCREEN/{$DETAIL_SCREEN_NAME}/{$DETAIL_SCREEN_DOSE}/{$DETAIL_SCREEN_STRENGTH}") {
        fun createRoute(name: String, dose: String, strength: String) = "$DETAIL_SCREEN/$name/$dose/$strength"
    }
}