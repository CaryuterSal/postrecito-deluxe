package mx.edu.utez.postrecitodeluxe.data

import mx.edu.utez.postrecitodeluxe.data.model.Cake
import mx.edu.utez.postrecitodeluxe.network.RetrofitClient
import retrofit2.Response

class CakeRepository {

    private val api = RetrofitClient.instance

    // Obtener todos los pasteles
    suspend fun getAllCakes(): Response<List<Cake>> {
        return api.getCakes()
    }

    // Crear un pastel
    suspend fun addCake(cake: Cake): Response<Cake> {
        return api.createCake(cake)
    }

    // Actualizar un pastel
    suspend fun updateCake(cake: Cake): Response<Cake> {
        return api.updateCake(cake.id, cake)
    }

    // Eliminar un pastel
    suspend fun deleteCake(id: Int): Response<Map<String, Any>> {
        return api.deleteCake(id)
    }

    // Buscar un pastel por ID (localmente del GET completo)
    suspend fun getCakeById(id: Int): Cake? {
        val response = api.getCakes()
        return if (response.isSuccessful) {
            response.body()?.firstOrNull { it.id == id }
        } else null
    }
}

