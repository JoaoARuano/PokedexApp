package com.example.pokedex.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://pokeapi.co/api/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int, @Query("limit") limit: Int
    ): PokemonList

    @GET("pokemon/{idOrName}")
    suspend fun getPokemon(@Path("idOrName") idOrName: String): Pokemon
}

object PokeApi {
    val retrofitService: PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }
}

