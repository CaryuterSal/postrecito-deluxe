package mx.edu.utez.postrecitodeluxe.data.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import mx.edu.utez.postrecitodeluxe.R

enum class CakeFilling(@DrawableRes val icon: Int, val color: Color) {
    CHOCOLATE(R.drawable.chocolate, Color(0xFF361E15)),
    PASTRY_CREAM(R.drawable.pastrycream, Color(0xFFF5E4BA)),
    STRAWBERRY_JAM(R.drawable.strawberryjam, Color(0xFF8A0125));

    override fun toString(): String {
        return when(this){
            CHOCOLATE -> "Chocolate"
            PASTRY_CREAM -> "Crema Pastelera"
            STRAWBERRY_JAM -> "Mermelada de Fresa"
        }
    }
}