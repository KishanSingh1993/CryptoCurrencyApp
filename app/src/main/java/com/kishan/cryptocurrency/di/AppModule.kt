package com.kishan.cryptocurrency.di

import android.app.Application
import androidx.room.Room
import com.kishan.cryptocurrency.common.Constants
import com.kishan.cryptocurrency.data.local.CoinDatabase
import com.kishan.cryptocurrency.data.local.converters.LinksConverter
import com.kishan.cryptocurrency.data.local.converters.TagListConverter
import com.kishan.cryptocurrency.data.local.converters.TeamMemberListConverter
import com.kishan.cryptocurrency.data.local.converters.WhitepaperConverter
import com.kishan.cryptocurrency.data.remote.CoinPaprikaAPI
import com.kishan.cryptocurrency.data.repository.CoinRepositoryImpl
import com.kishan.cryptocurrency.data.util.GsonParser
import com.kishan.cryptocurrency.domain.repository.CoinRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaAPI(): CoinPaprikaAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)

    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaAPI, db: CoinDatabase): CoinRepository {
        return CoinRepositoryImpl(api, db)
    }

    @Provides
    @Singleton
    fun provideCoinDatabase(app: Application): CoinDatabase {
        return Room.databaseBuilder(
            app,
            CoinDatabase::class.java,
            "coindb.db"
        )
            .addTypeConverter(TagListConverter((GsonParser(Gson()))))
            .addTypeConverter(TeamMemberListConverter((GsonParser(Gson()))))
            .addTypeConverter(LinksConverter((GsonParser(Gson()))))
            .addTypeConverter(WhitepaperConverter((GsonParser(Gson()))))
            .build()
    }

}