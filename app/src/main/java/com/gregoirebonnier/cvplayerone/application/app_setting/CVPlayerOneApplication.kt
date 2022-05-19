package com.gregoirebonnier.cvplayerone.application.app_setting

import android.app.Application
import com.gregoirebonnier.cvplayerone.application.module.domainModule
import com.gregoirebonnier.cvplayerone.application.module.localDataSourceModule
import com.gregoirebonnier.cvplayerone.application.module.repositoryModule
import com.gregoirebonnier.cvplayerone.application.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CVPlayerOneApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@CVPlayerOneApplication)
            // use properties from assets/koin.properties
            androidFileProperties()
            // use modules
            modules(
                viewModelModule(),
                localDataSourceModule(),
                repositoryModule(),
                domainModule(),
            )
        }

    }
}