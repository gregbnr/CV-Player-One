package com.gregoirebonnier.cvplayerone.ui.profile

import com.gregoirebonnier.cvplayerone.application.app_setting.base.UiEffect
import com.gregoirebonnier.cvplayerone.application.app_setting.base.UiEvent
import com.gregoirebonnier.cvplayerone.application.app_setting.base.UiState


class ProfileContract {

    sealed class Effect : UiEffect {
        object OnUserSendEmail : Effect()
    }

    sealed class Event : UiEvent {
        object OnUserUpdateDarkMode : Event()
        object OnUserClickOnEmail : Event()

    }

    data class State(
        val isDarkMode: Boolean,
    ) : UiState
}