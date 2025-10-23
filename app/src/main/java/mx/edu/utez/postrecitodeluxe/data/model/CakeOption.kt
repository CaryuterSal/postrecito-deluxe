package mx.edu.utez.postrecitodeluxe.data.model

import androidx.annotation.DrawableRes


interface CakeOption {
    override fun toString(): String
    @get:DrawableRes val icon: Int
}