package mx.edu.utez.postrecitodeluxe.data.model

data class Cake (
    val id: Int,
    val sabor: CakeFlavor,
    val glaseado: CakeFrosting,
    val topping: CakeTopping,
    val relleno: CakeFilling,
    val tamanio: CakeSize,
    val forma: CakeShape
)