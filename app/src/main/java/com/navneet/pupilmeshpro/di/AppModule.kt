package com.navneet.pupilmeshpro.di

import android.content.Context
import androidx.room.Room
import com.navneet.pupilmeshpro.AppDatabase
import com.navneet.pupilmeshpro.domain.entities.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):
            AppDatabase = Room.databaseBuilder(
        context, AppDatabase::class.java, "app_database")
        .build()


    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()

}