package com.gregoirebonnier.cvplayerone.ui.experience

import android.app.Application
import com.gregoirebonnier.cvplayerone.application.base.BaseViewModel

class ExperienceViewModel(
    application: Application,
) : BaseViewModel<ExperienceContract.Event, ExperienceContract.State, ExperienceContract.Effect>(
    application) {

    override fun createInitialState(): ExperienceContract.State {
        return ExperienceContract.State(
            isDarkMode = false
        )
    }

    override fun handleEvent(event: ExperienceContract.Event) {
        when (event) {

        }
    }

    init {

    }

}