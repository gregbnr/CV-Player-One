package com.gregoirebonnier.cvplayerone.application.module

import com.gregoirebonnier.cvplayerone.MainViewModel
import com.gregoirebonnier.cvplayerone.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {
    viewModel { MainViewModel(get(), get(), get()) }
    viewModel { ProfileViewModel(get(), get(), get()) }
}