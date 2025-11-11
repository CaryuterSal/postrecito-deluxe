package mx.edu.utez.postrecitodeluxe.network

import mx.edu.utez.postrecitodeluxe.data.model.Cake
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface CakeApiService {

    // Obtener todos los pasteles
    @GET("cakes")
    suspend fun getCakes(): Response<List<Cake>>

    // Crear un pastel
    @POST("cakes")
    suspend fun createCake(@Body cake: Cake): Response<Cake>

    // Actualizar un pastel
    @PUT("cakes/{id}")
    suspend fun updateCake(@Path("id") id: Int, @Body cake: Cake): Response<Cake>

    // Eliminar un pastel
    @DELETE("cakes/{id}")
    suspend fun deleteCake(@Path("id") id: Int): Response<Map<String, Any>>
}
