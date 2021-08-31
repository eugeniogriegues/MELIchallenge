package com.example.melichallenge.model

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object ApiClient {

    private const val BASE_URL = "https://api.mercadolibre.com/"

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build() // SE CREA UNA VARIABLE PARA EL MOSHI BUILDER, AGREGANDOLE UN CONVERSOR

    private val retrofit: Retrofit by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}


interface ApiService {

    @GET ("/sites/MLA/search")

    fun lanzarCall (@Query ("q") q: String,
                    @Query ("limit") limit: Int) : Call<ItemResponse>

}