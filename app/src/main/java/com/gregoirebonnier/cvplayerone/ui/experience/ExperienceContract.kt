package com.gregoirebonnier.cvplayerone.ui.experience

import com.gregoirebonnier.cvplayerone.application.base.UiEffect
import com.gregoirebonnier.cvplayerone.application.base.UiEvent
import com.gregoirebonnier.cvplayerone.application.base.UiState


class ExperienceContract {

    sealed class Effect : UiEffect {

    }

    sealed class Event : UiEvent {

    }

    data class State(
        val isDarkMode: Boolean,
    ) : UiState
}