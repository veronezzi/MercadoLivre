package com.example.mercadolivre

import android.app.Application
//import com.example.mercadolivre.di.repositoryModule
//import com.example.mercadolivre.di.useCaseModule
import com.example.mercadolivre.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
//                repositoryModule,
//                useCaseModule,
                viewModelModule
            )
        }
    }
}