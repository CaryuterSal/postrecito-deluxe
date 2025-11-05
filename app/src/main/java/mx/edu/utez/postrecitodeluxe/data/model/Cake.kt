package mx.edu.utez.postrecitodeluxe.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cake (
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    var sabor: CakeFlavor,
    var glaseado: CakeFrosting,
    var topping: CakeTopping,
    var relleno: CakeFilling,
    var tamanio: CakeSize,
    var forma: CakeShape
)