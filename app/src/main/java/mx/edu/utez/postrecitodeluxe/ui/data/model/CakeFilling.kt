package mx.edu.utez.postrecitodeluxe.ui.data.model

import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeFrosting.CREAM
import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeFrosting.STRAWBERRY
import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeFrosting.VANILLA

enum class CakeFilling {
    CHOCOLATE,
    PASTRY_CREAM,
    STRAWBERRY_JAM;


    override fun toString(): String {
        return when(this){
            CHOCOLATE -> "Chocolate"
            PASTRY_CREAM -> "Crema Pastelera"
            STRAWBERRY_JAM -> "Mermelada de Fresa"
        }
    }
}