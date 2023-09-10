package it.macgood.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import it.macgood.reservation.data.api.ReservationApi
import it.macgood.reservation.data.repository.ReservationRepositoryImpl
import it.macgood.reservation.domain.repository.ReservationRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ReservationModule {

    @Provides
    @Singleton
    fun provideReservationApi(
        client: OkHttpClient,
        @Named("baseUrl") baseUrl: String
    ): ReservationApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ReservationApi::class.java)

    @Singleton
    @Provides
    fun provideReservationRepository(
        api: ReservationApi,
        @ApplicationContext context: Context
    ): ReservationRepository = ReservationRepositoryImpl(api, context)
}