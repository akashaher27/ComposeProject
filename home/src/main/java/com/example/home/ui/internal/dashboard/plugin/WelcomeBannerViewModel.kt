package com.example.home.ui.internal.dashboard.plugin

import androidx.compose.ui.res.stringResource
import com.example.core.util.DateTimeProvider
import com.example.home.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

internal class WelcomeBannerViewModel @Inject constructor(
    private val dateTimeProvider: DateTimeProvider
) {

    private val _welcomeBannerViewState = MutableStateFlow(ViewState.DEFAULT)
    val welcomeBannerViewState = _welcomeBannerViewState

    init {
        getRandomGreeting()
    }

    private fun getRandomGreeting() {
        val timeBasedGreeting = when (dateTimeProvider.datetime().hour) {
            in 0..11 -> R.string.greeting_good_morning
            in 12..17 -> R.string.greeting_good_afternoon
            else -> R.string.greeting_good_evening
        }

        val message = listOf(
            R.string.greeting_hi,
            R.string.greeting_hello,
            timeBasedGreeting
        ).random()
        _welcomeBannerViewState.update {
            it.copy(
                welcomeMessage = message
            )
        }
    }
}

internal data class ViewState(
    val welcomeMessage: Int,
    val userName: String
) {
    companion object {
        val DEFAULT = ViewState(
            welcomeMessage = R.string.greeting_hi,
            userName = "Akash"
        )
    }
}