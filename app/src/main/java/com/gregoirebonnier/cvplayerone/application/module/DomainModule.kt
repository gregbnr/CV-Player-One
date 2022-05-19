package com.gregoirebonnier.cvplayerone.application.module

import com.gregoirebonnier.cvplayerone.application.domain.app.ObserveIsDarkModeActivatedUseCase
import com.gregoirebonnier.cvplayerone.application.domain.app.UpdateDarkModeUseCase
import org.koin.dsl.module

fun domainModule() = module {
    factory { ObserveIsDarkModeActivatedUseCase(get()) }
    factory { UpdateDarkModeUseCase(get()) }
}