package com.gregoirebonnier.cvplayerone.domain.app

import com.gregoirebonnier.cvplayerone.data.repository.AppRepo

class UpdateDarkModeUseCase(
    private val appRepo: AppRepo,
) {
    suspend operator fun invoke(isActivated: Boolean) {
        appRepo.updateDarkMode(isActivated)
    }
}