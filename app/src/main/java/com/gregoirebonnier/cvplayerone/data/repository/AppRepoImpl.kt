package com.gregoirebonnier.cvplayerone.data.repository

import com.gregoirebonnier.cvplayerone.data.local_data_source.AppLocalDataSource
import kotlinx.coroutines.flow.Flow

class AppRepoImpl(
    private val localDataSource: AppLocalDataSource,
) : AppRepo {
    override fun observeIsDarkModeActivated(): Flow<Boolean> {
        return localDataSource.observeIsDarkModeActivated()
    }

    override suspend fun updateDarkMode(isActivated: Boolean) {
        localDataSource.updateDarkMode(isActivated)
    }

}