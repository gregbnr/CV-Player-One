package com.gregoirebonnier.cvplayerone.application.module

import com.gregoirebonnier.cvplayerone.application.data.repository.AppRepo
import com.gregoirebonnier.cvplayerone.application.data.repository.AppRepoImpl
import org.koin.dsl.module

fun repositoryModule() = module {
    single { AppRepoImpl(get()) as AppRepo }
}