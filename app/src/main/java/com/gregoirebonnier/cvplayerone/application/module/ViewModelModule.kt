package com.gregoirebonnier.cvplayerone.application.module

import com.gregoirebonnier.cvplayerone.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {
    viewModel { MainViewModel() }
}