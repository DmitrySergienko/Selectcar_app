package com.example.selectcarapp.di

import android.content.Context
import androidx.room.Room
import com.example.selectcarapp.data.CarsDao
import com.example.selectcarapp.data.CarsDatabase
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
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        CarsDatabase::class.java,
        "new_db"
    ).build()

    @Provides
    fun provideYourDao(database: CarsDatabase): CarsDao {
        return database.carsDao()
    }

}