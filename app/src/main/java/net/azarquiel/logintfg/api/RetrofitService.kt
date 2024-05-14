package net.azarquiel.logintfg.api

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