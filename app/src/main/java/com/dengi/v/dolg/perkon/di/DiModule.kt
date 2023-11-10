package com.dengi.v.dolg.perkon.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.dengi.v.dolg.perkon.data.RepositoryAnalyticImpl
import com.dengi.v.dolg.perkon.data.RepositoryServerImpl
import com.dengi.v.dolg.perkon.data.ServiceImpl
import com.dengi.v.dolg.perkon.data.SharedKeeperImpl
import com.dengi.v.dolg.perkon.domain.RepositoryAnalytic
import com.dengi.v.dolg.perkon.domain.RepositoryServer
import com.dengi.v.dolg.perkon.domain.Service
import com.dengi.v.dolg.perkon.domain.SharedKepper
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {

    @Binds
    @Singleton
    abstract fun bindService(service: ServiceImpl): Service

    @Binds
    @Singleton
    abstract fun bindKeeper(sharedKeeper: SharedKeeperImpl): SharedKepper

    @Binds
    @Singleton
    abstract fun bindRepositoryAnalytic(repository: RepositoryAnalyticImpl): RepositoryAnalytic

    @Binds
    @Singleton
    abstract fun bindRepositoryServer(repository: RepositoryServerImpl): RepositoryServer

}