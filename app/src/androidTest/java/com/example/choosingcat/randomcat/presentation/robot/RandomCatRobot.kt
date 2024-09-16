package com.example.choosingcat.randomcat.presentation.robot

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.choosingcat.R
import org.hamcrest.CoreMatchers.not

class RandomCatRobot {
    fun checkImageIsDisplayed() {
        onView(withId(R.id.catImageView)).check(matches(isDisplayed()))
    }

    fun checkTitleIsDisplayed(text: String) {
        onView(withId(R.id.titleTextView)).check(matches(withText(text)))
    }

    fun checkLoadingIsDisplayed() {
        onView(withId(R.id.loadingProgressBar)).check(matches(isDisplayed()))
    }

    fun checkLoadingIsNotDisplayed() {
        onView(withId(R.id.loadingProgressBar)).check(matches(not(isDisplayed())))
    }

    fun checkErrorIsDisplayed() {
        onView(withId(R.id.errorTextView)).check(matches(isDisplayed()))
    }

    fun clickReloadButton() {
        onView(withId(R.id.reloadCatButton)).perform(click())
    }

    fun clickSavedCatsButton() {
        onView(withId(R.id.savedCatsButton)).perform(click())
    }
}
