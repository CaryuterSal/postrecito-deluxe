package mx.edu.utez.postrecitodeluxe.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

object RetrofitClient {

    private const val BASE_URL = "https://pasteleria-deluxe-api.fly.dev/"

    val instance: CakeApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CakeApiService::class.java)
    }
}
