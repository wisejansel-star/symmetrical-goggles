package uca.edu.reqres.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import uca.edu.reqres.repository.ReqresRepository
import uca.edu.reqres.retrofit.NetworkMapper
import uca.edu.reqres.retrofit.ReqresRetrofit
import uca.edu.reqres.room.CacheMapper
import uca.edu.reqres.room.ReqresDao
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)

object RepositoryModule {

    @Singleton
    @Provides
    fun provideReqresRepository(
        reqresDao: ReqresDao,
        reqresRetrofit: ReqresRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): ReqresRepository {
        return ReqresRepository(reqresDao, reqresRetrofit, cacheMapper, networkMapper)
    }
}