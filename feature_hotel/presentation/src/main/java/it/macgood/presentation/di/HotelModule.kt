package it.macgood.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import it.macgood.hotel.data.HotelApi
import it.macgood.hotel.data.HotelRepositoryImpl
import it.macgood.hotel.domain.HotelRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HotelModule {

    @Provides
    @Singleton
    fun provideHotelApi(
        client: OkHttpClient,
        @Named("baseUrl") baseUrl: String
    ): HotelApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(HotelApi::class.java)
    @Singleton
    @Provides
    fun provideHotelRepository(
        api: HotelApi,
        @ApplicationContext context: Context
    ): HotelRepository = HotelRepositoryImpl(api, context)
}