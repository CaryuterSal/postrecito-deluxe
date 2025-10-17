package mx.edu.utez.postrecitodeluxe.ui.data.model

enum class CakeFrosting {
    CHOCOLATE,
    VANILLA,
    STRAWBERRY,
    CREAM;

    override fun toString(): String {
        return when(this){
            CHOCOLATE -> "Chocolate"
            VANILLA -> "Vainilla"
            CREAM -> "Crema"
            STRAWBERRY -> "Fresa"
        }
    }
}