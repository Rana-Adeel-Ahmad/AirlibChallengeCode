package com.example.arlibtestcode.di

import com.example.arlibtestcode.domain.repositery.MedicineRepositery
import com.example.arlibtestcode.network.repositery.MedicineRepositoryImpl
import com.example.arlibtestcode.network.service.MedicineService
import com.example.arlibtestcode.util.Const.PAGE_SIZE
import com.example.arlibtestcode.util.Const.WEB_API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Named("WEB_API")
    fun provideWebAPI(): String = WEB_API

    @Provides
    @Named("PAGE_SIZE")
    fun providePageSize(): Int = PAGE_SIZE

    @Provides
    fun provideRetrofit(
        @Named("WEB_API") webAPI: String,
    ): Retrofit {
        val client = OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
        return Retrofit.Builder()
            .baseUrl(webAPI)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun provideMedicineService(
        retrofit: Retrofit
    ): MedicineService = retrofit.create(MedicineService::class.java)

    @Provides
    fun provideMedicineRepository(
        medicineService: MedicineService,
        @Named("PAGE_SIZE") pageSize: Int,
    ): MedicineRepositery = MedicineRepositoryImpl(
        medicineService = medicineService
    )

}