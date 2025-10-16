package mx.edu.utez.postrecitodeluxe.ui.data.model

enum class CakeShape {
    SQUARE,
    ROUND,
    HEART;

    override fun toString(): String {
        return when(this){
            SQUARE -> "Cuadrado"
            ROUND -> "Redondo"
            HEART -> "Corazón"
        }
    }
}