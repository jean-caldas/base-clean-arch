package com.example.baseclean.di

import com.example.baseclean.data.tvshow.network.TvShowMapper
import com.example.baseclean.data.tvshow.network.TvShowService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideHttpClient(token: String): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor {
            val request = it.request().newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()

            it.proceed(request)
        }.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(client)
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideTvShowMapper(): TvShowMapper {
        return TvShowMapper()
    }

    @Singleton
    @Provides
    fun provideTvShowService(retrofit: Retrofit.Builder): TvShowService =
        retrofit.build().create(TvShowService::class.java)

    @Singleton
    @Provides
    fun provideToken(): String =
        "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1MjBlYTNmNDcxNjBkODI3NzM3MGYxZTBjNTlkMDBjZSIsInN1YiI6IjYwYmNmOGQ3YmIyNjAyMDAyOWQ5YTk1NyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.vNB6zktZ78jT0Ffy4GYPvrg-Sfyw4jXzqLfk_mP1fc8"
}