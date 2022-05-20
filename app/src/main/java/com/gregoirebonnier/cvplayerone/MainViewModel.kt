package com.gregoirebonnier.cvplayerone

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.gregoirebonnier.cvplayerone.application.base.BaseViewModel
import com.gregoirebonnier.cvplayerone.domain.app.ObserveIsDarkModeActivatedUseCase
import com.gregoirebonnier.cvplayerone.domain.app.UpdateDarkModeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    application: Application,
    private val updateDarkModeUseCase: UpdateDarkModeUseCase,
    private val observeIsDarkModeActivatedUseCase: ObserveIsDarkModeActivatedUseCase,
) : BaseViewModel<MainContract.Event, MainContract.State, MainContract.Effect>(application) {

    override fun createInitialState(): MainContract.State {
        return MainContract.State(
            isDarkMode = false
        )
    }

    override fun handleEvent(event: MainContract.Event) {
        when (event) {
            is MainContract.Event.OnUserUpdateDarkMode -> updateDarkMode(event.isDarkModeActivated)
        }
    }

    init {
        observeIsDarkMode()
    }


    /**
     * Get info if the dark mode is active or not
     */
    private fun observeIsDarkMode() {
        viewModelScope.launch {
            observeIsDarkModeActivatedUseCase().collect {
                setState { copy(isDarkMode = it) }
            }
        }
    }

    /**
     * Get info if the dark mode is active or not
     */
    private fun updateDarkMode(isDarkModeActivated: Boolean) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                updateDarkModeUseCase(isDarkModeActivated)
            }
        }
    }
}