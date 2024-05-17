package net.azarquiel.logintfg.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.azarquiel.logintfg.api.MainRepository

class MainViewModel : ViewModel() {
    private val repository: MainRepository = MainRepository()

    private val _folders = MutableStateFlow<List<String>>(emptyList())
    val folders: StateFlow<List<String>> get() = _folders

    fun loadFolders() {
        viewModelScope.launch {
            _folders.value = repository.getFolders().filterNotNull()
        }
    }

    fun getFoldersByCategory(categoria: String): LiveData<List<String?>> {
        val folders = MutableLiveData<List<String?>>()
        viewModelScope.launch {
            folders.value = repository.getFoldersByCategory(categoria)
        }
        return folders
    }

    fun getCategoriesByStyle(categoria: String, estilo: String): LiveData<List<String?>> {
        val images = MutableLiveData<List<String?>>()
        viewModelScope.launch {
            images.value = repository.getCategoriesByStyle(categoria, estilo)
        }
        return images
    }
}
