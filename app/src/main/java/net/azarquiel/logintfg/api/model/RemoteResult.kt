package net.azarquiel.logintfg.api.model


import com.google.gson.annotations.SerializedName

data class RemoteResult(
    @SerializedName("folders")
    val folders: List<String?>?,
    @SerializedName("images")
    val images: List<String?>?
)