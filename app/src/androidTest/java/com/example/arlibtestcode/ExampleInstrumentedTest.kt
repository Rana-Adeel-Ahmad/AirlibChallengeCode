package com.example.arlibtestcode

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.arlibtestcode.domain.repositery.MedicineRepositery
import com.example.arlibtestcode.viewmodel.HomeViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    lateinit var SUT: HomeViewModel

    @Before
    fun init() {
        SUT = HomeViewModel()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.arlibtestcode", appContext.packageName)
    }


}