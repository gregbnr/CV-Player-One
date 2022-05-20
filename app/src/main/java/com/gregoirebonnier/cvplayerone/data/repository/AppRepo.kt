package com.gregoirebonnier.cvplayerone.data.repository

import kotlinx.coroutines.flow.Flow

interface AppRepo {

    fun observeIsDarkModeActivated(): Flow<Boolean>

    suspend fun updateDarkMode(isActivated: Boolean)
}