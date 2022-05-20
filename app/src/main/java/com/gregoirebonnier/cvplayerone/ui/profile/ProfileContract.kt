package com.gregoirebonnier.cvplayerone.ui.profile

import com.gregoirebonnier.cvplayerone.application.base.UiEffect
import com.gregoirebonnier.cvplayerone.application.base.UiEvent
import com.gregoirebonnier.cvplayerone.application.base.UiState


class ProfileContract {

    sealed class Effect : UiEffect {
        object OnUserSendEmail : Effect()
        object OnUserOpenLinkedIn : Effect()
    }

    sealed class Event : UiEvent {
        object OnUserUpdateDarkMode : Event()
        object OnUserClickOnEmail : Event()
        object OnUserClickOnLinkedIn : Event()
    }

    data class State(
        val isDarkMode: Boolean,
    ) : UiState
}