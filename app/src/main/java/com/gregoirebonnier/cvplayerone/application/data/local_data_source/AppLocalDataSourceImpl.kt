package com.gregoirebonnier.cvplayerone.application.data.local_data_source

import com.gregoirebonnier.cvplayerone.application.data.datastore.CVPlayerOneDataStore
import com.gregoirebonnier.cvplayerone.application.data.datastore.PreferenceKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppLocalDataSourceImpl(
    private val datastore: CVPlayerOneDataStore,
) : AppLocalDataSource {
    override fun observeIsDarkModeActivated(): Flow<Boolean> {
        return datastore.getValueObs(PreferenceKeys.IS_DARK_MODE).map {
            it ?: false
        }
    }

    override suspend fun updateDarkMode(isActivated: Boolean) {
        datastore.storeValue(PreferenceKeys.IS_DARK_MODE, isActivated)
    }

}