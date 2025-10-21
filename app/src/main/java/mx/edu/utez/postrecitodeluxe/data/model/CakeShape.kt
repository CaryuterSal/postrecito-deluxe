package mx.edu.utez.postrecitodeluxe.data.model

import androidx.annotation.DrawableRes
import mx.edu.utez.postrecitodeluxe.R

enum class CakeShape(@DrawableRes val icon: Int, @DrawableRes val previewImageRes: Int) {
    SQUARE(R.drawable.squarecake, R.drawable.square),
    ROUND(R.drawable.circlecake, R.drawable.circle),
    HEART(R.drawable.heartcake, R.drawable.heart);

    override fun toString(): String {
        return when(this){
            SQUARE -> "Cuadrado"
            ROUND -> "Redondo"
            HEART -> "Corazón"
        }
    }
}