package net.azarquiel.logintfg.api

import net.azarquiel.logintfg.api.model.RemoteResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitService {
    @GET("folders/")
    suspend fun getFolders(): RemoteResult

    @GET("folders/{categoria}")
    suspend fun getFoldersByCategory(
        @Path("categoria") categoria: String
    ): RemoteResult

    @GET("folders/{categoria}/{estilo}")
    suspend fun getCategoriesByStyle(
        @Path("categoria") categoria: String,
        @Path("estilo") estilo: String
    ): RemoteResult
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://apimep.azurewebsites.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }
}
