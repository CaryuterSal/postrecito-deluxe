package mx.edu.utez.postrecitodeluxe.ui.data.model

import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeFrosting.CREAM
import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeFrosting.STRAWBERRY

enum class CakeFlavor {
    CHOCOLATE,
    VANILLA,
    CARROT,
    RED_VELVET;

    override fun toString(): String {
        return when(this){
            CHOCOLATE -> "Chocolate"
            VANILLA -> "Vainilla"
            CARROT -> "Zanahoria"
            RED_VELVET -> "Red Velvet"
        }
    }

}