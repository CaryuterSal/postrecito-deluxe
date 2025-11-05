package mx.edu.utez.postrecitodeluxe.data

import kotlinx.coroutines.flow.Flow
import mx.edu.utez.postrecitodeluxe.data.model.Cake

class CakeRepository(
    private val dao: CakeDao
) {

    val cakes = dao.getAll()

    suspend fun addCake(cake: Cake) {
        dao.insert(cake)
    }

    suspend fun updateCake(cake: Cake) {
        dao.update(cake)
    }
    suspend fun deleteCake(cake: Cake) {
        dao.delete(cake)
    }
    fun getCakeById(id: Int): Flow<Cake> {
        return dao.getById(id)
    }
    fun getAllCakes(): Flow<List<Cake>> {
        return dao.getAll()
    }

}