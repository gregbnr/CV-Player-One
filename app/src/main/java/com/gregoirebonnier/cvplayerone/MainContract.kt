package com.gregoirebonnier.cvplayerone

import com.gregoirebonnier.cvplayerone.application.app_setting.base.UiEffect
import com.gregoirebonnier.cvplayerone.application.app_setting.base.UiEvent
import com.gregoirebonnier.cvplayerone.application.app_setting.base.UiState


class MainContract {

    sealed class Effect : UiEffect {
        data class UpdateDarkMode(val isDarkModeActivated: Boolean) : Effect()
    }

    sealed class Event : UiEvent {
        data class OnUserUpdateDarkMode(val isDarkModeActivated: Boolean) : Event()

    }

    data class State(
        val isDarkMode: Boolean,
    ) : UiState
}