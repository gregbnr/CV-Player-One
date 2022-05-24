package com.gregoirebonnier.cvplayerone

import com.gregoirebonnier.cvplayerone.application.base.UiEffect
import com.gregoirebonnier.cvplayerone.application.base.UiEvent
import com.gregoirebonnier.cvplayerone.application.base.UiState


class MainContract {

    sealed class Effect : UiEffect {

    }

    sealed class Event : UiEvent {
        data class OnUserUpdateDarkMode(val isDarkModeActivated: Boolean) : Event()

    }

    data class State(
        val isDarkMode: Boolean,
    ) : UiState
}