package mx.edu.utez.postrecitodeluxe.data.model

import androidx.annotation.DrawableRes
import mx.edu.utez.postrecitodeluxe.R

enum class CakeSize(@DrawableRes val icon: Int, @DrawableRes val previewImageRes: Int) {

    SMALL(R.drawable.smallcake, R.drawable.small_base),
    MEDIUM(R.drawable.mediumcake, R.drawable.medium_base),
    LARGE(R.drawable.bigcake, R.drawable.big_base);

    override fun toString(): String {
        return when(this){
            SMALL -> "Pequeño"
            MEDIUM -> "Mediano"
            LARGE -> "Grande"
        }
    }

}