package com.example.arlibtestcode.util

object Const {
    //Screens
    const val LOGIN_SCREEN = "login"
    const val HOME_SCREEN = "home"
    const val DETAIL_SCREEN = "detail"
    const val HOME_SCREEN_EMAIL = "homeEmail"
    const val DETAIL_SCREEN_NAME = "detailName"
    const val DETAIL_SCREEN_DOSE = "detailDose"
    const val DETAIL_SCREEN_STRENGTH = "detailStrength"

    const val PAGE_SIZE = 20
    const val WEB_API = "https://run.mocky.io/v3/"

    inline fun <T1: Any, T2: Any, R: Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2)->R?): R? {
        return if (p1 != null && p2 != null) block(p1, p2) else null
    }
    inline fun <T1: Any, T2: Any, T3: Any, R: Any> safeLet(p1: T1?, p2: T2?, p3: T3?, block: (T1, T2, T3)->R?): R? {
        return if (p1 != null && p2 != null && p3 != null) block(p1, p2, p3) else null
    }
    inline fun <T1: Any, T2: Any, T3: Any, T4: Any, R: Any> safeLet(p1: T1?, p2: T2?, p3: T3?, p4: T4?, block: (T1, T2, T3, T4)->R?): R? {
        return if (p1 != null && p2 != null && p3 != null && p4 != null) block(p1, p2, p3, p4) else null
    }
    inline fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, R: Any> safeLet(p1: T1?, p2: T2?, p3: T3?, p4: T4?, p5: T5?, block: (T1, T2, T3, T4, T5)->R?): R? {
        return if (p1 != null && p2 != null && p3 != null && p4 != null && p5 != null) block(p1, p2, p3, p4, p5) else null
    }
}