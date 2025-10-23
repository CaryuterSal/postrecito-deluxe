package mx.edu.utez.postrecitodeluxe.data.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import mx.edu.utez.postrecitodeluxe.R

enum class CakeTopping(@DrawableRes override val icon: Int, val color: Color = Color.Transparent): CakeOption {
    SPRINKLES(R.drawable.sprinkles),
    STRAWBERRIES(R.drawable.fresa, Color(0xFFF60202)),
    COOKIES(R.drawable.cookie, Color(0xFF932204));


    override fun toString(): String {
        return when(this){
            SPRINKLES -> "Chispitas"
            STRAWBERRIES -> "Fresas"
            COOKIES -> "Galletas"
        }
    }
}