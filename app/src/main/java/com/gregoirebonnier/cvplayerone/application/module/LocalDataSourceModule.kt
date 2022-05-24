package com.gregoirebonnier.cvplayerone.application.module

import com.gregoirebonnier.cvplayerone.data.datastore.CVPlayerOneDataStore
import com.gregoirebonnier.cvplayerone.data.local_data_source.AppLocalDataSource
import com.gregoirebonnier.cvplayerone.data.local_data_source.AppLocalDataSourceImpl
import org.koin.dsl.module

fun localDataSourceModule() = module {
    single { CVPlayerOneDataStore(get()) }
    factory { AppLocalDataSourceImpl(get()) as AppLocalDataSource }
}