package mx.edu.utez.postrecitodeluxe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mx.edu.utez.postrecitodeluxe.data.CakeRepository
import mx.edu.utez.postrecitodeluxe.data.model.Cake
import mx.edu.utez.postrecitodeluxe.data.model.CakeFilling
import mx.edu.utez.postrecitodeluxe.data.model.CakeFlavor
import mx.edu.utez.postrecitodeluxe.data.model.CakeFrosting
import mx.edu.utez.postrecitodeluxe.data.model.CakeShape
import mx.edu.utez.postrecitodeluxe.data.model.CakeSize
import mx.edu.utez.postrecitodeluxe.data.model.CakeTopping
import mx.edu.utez.postrecitodeluxe.persistence.AppDatabase


class CakeViewModel(application: Application): AndroidViewModel(application) {

    private val repo: CakeRepository

    val cakeList: StateFlow<List<Cake>>

    private val _selectedCake = MutableStateFlow<Int?>(null)
    val selectedCake = _selectedCake.asStateFlow()

    init {
        val db = AppDatabase.getInstance(application)
        repo = CakeRepository(db.cakeDao())

        // Room Flow → StateFlow para Compose
        cakeList = repo.cakes.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
    }

    fun selectCake(index: Int){
        _selectedCake.value = index
    }

    fun addCake(newCake: Cake) {
        viewModelScope.launch {
            repo.addCake(newCake)
        }
    }

    fun updateCake(newCake: Cake) {
        val selected = _selectedCake.value ?: return
        val cake = cakeList.value.getOrNull(selected) ?: return

        viewModelScope.launch {
            repo.updateCake(cake.copy(
                topping = newCake.topping,
                glaseado = newCake.glaseado,
                sabor = newCake.sabor,
                relleno = newCake.relleno,
                tamanio = newCake.tamanio,
                forma = newCake.forma
            ))
        }
    }

    fun deleteCake() {
        val selected = _selectedCake.value ?: return
        val cake = cakeList.value.getOrNull(selected) ?: return

        viewModelScope.launch {
            repo.deleteCake(cake)
            _selectedCake.value = null
        }
    }
}