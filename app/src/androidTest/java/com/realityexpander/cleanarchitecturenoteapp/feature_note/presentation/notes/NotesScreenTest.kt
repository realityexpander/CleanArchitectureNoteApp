package com.realityexpander.cleanarchitecturenoteapp.feature_note.presentation.notes

import android.content.Context
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import com.realityexpander.cleanarchitecturenoteapp.core.util.TestTags
import com.realityexpander.cleanarchitecturenoteapp.di.AppModule
import com.realityexpander.cleanarchitecturenoteapp.feature_note.presentation.MainActivity
import com.realityexpander.cleanarchitecturenoteapp.feature_note.presentation.util.Screen
import com.realityexpander.cleanarchitecturenoteapp.test.R
import com.realityexpander.cleanarchitecturenoteapp.ui.theme.CleanArchitectureNoteAppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class) // This is needed to avoid using the real AppModule, use TestAppModule instead
class NotesScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this) // Connects Hilt to the test

    @get:Rule(order = 1)
    val composeRule =
        createAndroidComposeRule<MainActivity>()  // Connects the Activity to the test with Compose

    @ExperimentalAnimationApi
    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.activity.setContent {
            val navController = rememberNavController()
            CleanArchitectureNoteAppTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screen.NotesScreen.route
                ) {
                    composable(route = Screen.NotesScreen.route) {
                        NotesScreen(navController = navController)
                    }
                }
            }
        }
    }

    @Test
    fun clickToggleOrderSection_isVisible() {

        // Access to AndroidTest resources/assets in src/androidTest/res
        val testContext = InstrumentationRegistry.getInstrumentation().context
        val testString = testContext.getString(com.realityexpander.cleanarchitecturenoteapp.test.R.string.Sort)
        println("R.string.Sort: $testString")

        // Access to Main resources/assets in src/main/res
        val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
        val string = targetContext.getString(R.string.app_name)
        println("R.string.app_name: $string")

        // Access to Main resources/assets
        val targetContextAlt = ApplicationProvider.getApplicationContext<Context>()
        val targetString1 = targetContextAlt.resources.getString(com.realityexpander.cleanarchitecturenoteapp.test.R.string.app_name)
        val targetString2 = composeRule.activity.getString(R.string.app_name)
        println("targetString1: $targetString1, targetString2: $targetString2")

        composeRule.onNodeWithTag(TestTags.ORDER_SECTION).assertDoesNotExist()

        // We can use the content description to find the button (label should be a String Resource)
        composeRule.onNodeWithContentDescription(testString).performClick()
        composeRule.onNodeWithTag(TestTags.ORDER_SECTION).assertIsDisplayed()
    }
}