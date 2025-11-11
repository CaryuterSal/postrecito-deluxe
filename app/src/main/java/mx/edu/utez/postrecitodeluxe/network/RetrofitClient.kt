package mx.edu.utez.postrecitodeluxe.network

import com.google.gson.GsonBuilder
import mx.edu.utez.postrecitodeluxe.data.model.CakeFlavor

import mx.edu.utez.postrecitodeluxe.data.model.CakeSize

import mx.edu.utez.postrecitodeluxe.data.model.CakeFrosting

import mx.edu.utez.postrecitodeluxe.data.model.CakeTopping

import mx.edu.utez.postrecitodeluxe.data.model.CakeFilling

import mx.edu.utez.postrecitodeluxe.data.model.CakeShape
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

object RetrofitClient {

    private val gson = GsonBuilder()
        .registerTypeAdapter(CakeFlavor::class.java, EnumDeserializer(CakeFlavor::class.java))
        .registerTypeAdapter(CakeFrosting::class.java, EnumDeserializer(CakeFrosting::class.java))
        .registerTypeAdapter(CakeTopping::class.java, EnumDeserializer(CakeTopping::class.java))
        .registerTypeAdapter(CakeFilling::class.java, EnumDeserializer(CakeFilling::class.java))
        .registerTypeAdapter(CakeSize::class.java, EnumDeserializer(CakeSize::class.java))
        .registerTypeAdapter(CakeShape::class.java, EnumDeserializer(CakeShape::class.java))
        .create()

    private const val BASE_URL = "https://pasteleria-deluxe-api.fly.dev/"

    val instance: CakeApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(CakeApiService::class.java)
    }
}
