package uca.edu.reqres.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import uca.edu.reqres.room.ReqresDao
import uca.edu.reqres.room.ReqresDatabase
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideReqresDb(@ApplicationContext context: Context): ReqresDatabase {
        return Room
            .databaseBuilder(context, ReqresDatabase::class.java, ReqresDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideReqresDao(reqresDatabase: ReqresDatabase): ReqresDao {
        return reqresDatabase.reqresDao()
    }
}