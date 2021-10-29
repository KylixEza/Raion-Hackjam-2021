package com.timhore.raionhackjam2021.di

import com.timhore.raionhackjam2021.data.datastore.Datastore
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val datastoreModule = module {
    single {
        Datastore(androidApplication())
    }
}