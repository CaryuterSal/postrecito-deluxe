package mx.edu.utez.postrecitodeluxe.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import mx.edu.utez.postrecitodeluxe.data.model.Cake
import mx.edu.utez.postrecitodeluxe.data.model.CakeFilling
import mx.edu.utez.postrecitodeluxe.data.model.CakeFlavor
import mx.edu.utez.postrecitodeluxe.data.model.CakeFrosting
import mx.edu.utez.postrecitodeluxe.data.model.CakeShape
import mx.edu.utez.postrecitodeluxe.data.model.CakeSize
import mx.edu.utez.postrecitodeluxe.data.model.CakeTopping

class CakeViewModel: ViewModel() {
    private val _cakeList = MutableStateFlow<List<Cake>>(emptyList())
    val cakeList = _cakeList.asStateFlow()

    private val _selectedCake = MutableStateFlow<Int?>(null)
    val selectedCake = _selectedCake.asStateFlow()

    init {
        _cakeList.value = listOf(
            Cake(
                CakeFlavor.CHOCOLATE,
                CakeFrosting.VANILLA,
                CakeTopping.SPRINKLES,
                CakeFilling.CHOCOLATE,
                CakeSize.LARGE,
                CakeShape.SQUARE
            ),
            Cake(
                CakeFlavor.RED_VELVET,
                CakeFrosting.STRAWBERRY,
                CakeTopping.STRAWBERRIES,
                CakeFilling.STRAWBERRY_JAM,
                CakeSize.MEDIUM,
                CakeShape.HEART
            )
        )
    }


    fun selectCake(index: Int){
        _selectedCake.update { index }
    }

    fun updateCake(newCake: Cake){
        _cakeList.update {
            it.mapIndexed { i, current ->
                if (_selectedCake.value != null && _selectedCake.value == i) newCake else current
            }
        }
    }

    fun addCake(newCake: Cake){
        _cakeList.update { it + newCake }
    }

    fun deleteCake(){
        _cakeList.update {
            it.filterIndexed { i, current ->
                _selectedCake.value == null || _selectedCake.value != i
            }
        }
        _selectedCake.update { null }
    }

}