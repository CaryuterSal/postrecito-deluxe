package mx.edu.utez.postrecitodeluxe.data.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import mx.edu.utez.postrecitodeluxe.R

enum class CakeFrosting(@DrawableRes override val icon: Int, val color: Color): CakeOption {
    CHOCOLATE(R.drawable.chocolate, Color(0xFF362315)),
    VANILLA(R.drawable.vanilla, Color(0xFFE7D19C)),
    STRAWBERRY(R.drawable.fresa, Color(0xFF8A0125)),
    CREAM(R.drawable.cream, Color(0xFFFDF8F6));

    override fun toString(): String {
        return when(this){
            CHOCOLATE -> "Chocolate"
            VANILLA -> "Vainilla"
            CREAM -> "Crema"
            STRAWBERRY -> "Fresa"
        }
    }
}