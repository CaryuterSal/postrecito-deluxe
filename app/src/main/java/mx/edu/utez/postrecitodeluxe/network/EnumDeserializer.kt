package mx.edu.utez.postrecitodeluxe.network

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class EnumDeserializer<T : Enum<T>>(private val enumClass: Class<T>) : JsonDeserializer<T> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): T? {
        val value = json?.asString ?: return null
        return enumClass.enumConstants?.firstOrNull {
            it.name.equals(value, ignoreCase = true)
        }
    }
}