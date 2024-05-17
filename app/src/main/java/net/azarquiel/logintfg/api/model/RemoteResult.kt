package net.azarquiel.logintfg.api.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RemoteResult(
    @SerializedName("folders")
    val folders: List<String?>?,
    @SerializedName("images")
    val images: List<String?>?
): Serializable