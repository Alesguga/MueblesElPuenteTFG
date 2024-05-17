package net.azarquiel.logintfg.api


class MainRepository {
    private val service = RetrofitServiceFactory.makeRetrofitService()

    suspend fun getFolders(): List<String?> {
        val response = service.getFolders()
        return response.folders ?: emptyList()
    }

    suspend fun getFoldersByCategory(categoria: String): List<String?> {
        val response = service.getFoldersByCategory(categoria)
        return response.folders ?: emptyList()
    }

    suspend fun getCategoriesByStyle(categoria: String, estilo: String): List<String?> {
        val response = service.getCategoriesByStyle(categoria, estilo)
        return response.images ?: emptyList()
    }
}
