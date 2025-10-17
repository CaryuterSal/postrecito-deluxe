package mx.edu.utez.postrecitodeluxe.ui.data.model

import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeFrosting.CHOCOLATE
import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeFrosting.CREAM
import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeFrosting.STRAWBERRY
import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeFrosting.VANILLA

enum class CakeTopping {
    SPRINKLES,
    STRAWBERRIES,
    COOKIES;


    override fun toString(): String {
        return when(this){
            SPRINKLES -> "Chispitas"
            STRAWBERRIES -> "Fresas"
            COOKIES -> "Galletas"
        }
    }
}