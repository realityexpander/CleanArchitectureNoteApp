package com.realityexpander.cleanarchitecturenoteapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.realityexpander.cleanarchitecturenoteapp", appContext.packageName)

        val string = appContext.getString(R.string.app_name)
        println("string: $string")

        val testContext = InstrumentationRegistry.getInstrumentation().context
        val testString = testContext.getString(com.realityexpander.cleanarchitecturenoteapp.test.R.string.Sort)
        println("testString: $testString")
    }
}