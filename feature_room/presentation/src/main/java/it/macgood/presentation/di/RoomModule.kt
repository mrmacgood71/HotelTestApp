package it.macgood.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import it.macgood.room.data.api.RoomsApi
import it.macgood.room.data.repository.RoomsRepositoryImpl
import it.macgood.room.domain.repository.RoomsRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideHotelApi(
        client: OkHttpClient
    ): RoomsApi = Retrofit.Builder()
        .baseUrl(RoomsApi.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RoomsApi::class.java)
    @Singleton
    @Provides
    fun provideHotelRepository(
        api: RoomsApi,
        @ApplicationContext context: Context
    ): RoomsRepository = RoomsRepositoryImpl(api, context)
}