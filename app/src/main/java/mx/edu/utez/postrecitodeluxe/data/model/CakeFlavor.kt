package mx.edu.utez.postrecitodeluxe.data.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import mx.edu.utez.postrecitodeluxe.R

enum class CakeFlavor(@DrawableRes val icon: Int, val color: Color) {
    CHOCOLATE(R.drawable.chocolate, Color(0xFF5E3920)),
    VANILLA(R.drawable.vanilla, Color(0xFFE3BCA0)),
    CARROT(R.drawable.carrot, Color(0xFFB95E1B)),
    RED_VELVET(R.drawable.redvevet, Color(0xFFB73030));

    override fun toString(): String {
        return when(this){
            CHOCOLATE -> "Chocolate"
            VANILLA -> "Vainilla"
            CARROT -> "Zanahoria"
            RED_VELVET -> "Red Velvet"
        }
    }

}