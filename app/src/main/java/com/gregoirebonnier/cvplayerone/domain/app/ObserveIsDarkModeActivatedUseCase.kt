package com.gregoirebonnier.cvplayerone.domain.app

import com.gregoirebonnier.cvplayerone.data.repository.AppRepo
import kotlinx.coroutines.flow.Flow

class ObserveIsDarkModeActivatedUseCase(
    private val appRepo: AppRepo,
) {
    operator fun invoke(): Flow<Boolean> {
        return appRepo.observeIsDarkModeActivated()
    }
}