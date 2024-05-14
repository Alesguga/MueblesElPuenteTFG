package net.azarquiel.logintfg.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("folders/")
    suspend fun getFolders(): List<Folder>

    @GET("folders/{categoria}")
    suspend fun getFoldersByCategory(
        @Path("categoria")
        categoria: String)
    : List<Folder>

    @GET("folders/{estuilo}")
    suspend fun getCategorysByStyle(
        @Path("estilo")
        estilo: String
    ): List<Folder>
}
object RetrofitServiceFactory{
    fun makeRetrofitService(): RetrofitService {
            return Retrofit.Builder()
                .baseUrl("https://apimep.azurewebsites.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitService::class.java)
        }

    }
}