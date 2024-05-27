package net.azarquiel.logintfg.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val storage = FirebaseStorage.getInstance()
    private val storageRef = storage.reference.child("FotosWeb")

    fun getFolders(): LiveData<List<String>> {
        val foldersLiveData = MutableLiveData<List<String>>()
        viewModelScope.launch {
            storageRef.listAll()
                .addOnSuccessListener { listResult ->
                    val folders = listResult.prefixes.map { it.name }
                    foldersLiveData.value = folders
                }
                .addOnFailureListener { exception ->
                    println("Error sacando las carpetas: $exception")
                }
        }
        return foldersLiveData
    }

    fun getFoldersByStyle(style: String): LiveData<List<String>> {
        val subfoldersLiveData = MutableLiveData<List<String>>()
        viewModelScope.launch {
            val styleRef = storageRef.child(style)
            styleRef.listAll()
                .addOnSuccessListener { listResult ->
                    val subfolders = listResult.prefixes.map { it.name }
                    subfoldersLiveData.value = subfolders
                }
                .addOnFailureListener { exception ->
                    println("Error sacando las subcarpetas: $exception")
                }
        }
        return subfoldersLiveData
    }
}
