package com.gregoirebonnier.cvplayerone.application.domain.app

import com.gregoirebonnier.cvplayerone.application.data.repository.AppRepo

class UpdateDarkModeUseCase(
    private val appRepo: AppRepo,
) {
    suspend operator fun invoke(isActivated: Boolean) {
        appRepo.updateDarkMode(isActivated)
    }
}