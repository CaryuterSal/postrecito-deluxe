package mx.edu.utez.postrecitodeluxe.ui.data.model

import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeShape.SQUARE

enum class CakeSize {

    SMALL,
    MEDIUM,
    LARGE;

    override fun toString(): String {
        return when(this){
            SMALL -> "Pequeño"
            MEDIUM -> "Mediano"
            LARGE -> "Grande"
        }
    }

}