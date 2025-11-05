package mx.edu.utez.postrecitodeluxe.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import mx.edu.utez.postrecitodeluxe.data.model.Cake

@Dao
interface CakeDao {

    @Query("SELECT * FROM Cake")
    fun getAll(): Flow<List<Cake>>

    @Query("SELECT * FROM Cake WHERE id = :id")
    fun getById(id: Int): Flow<Cake>

    @Update
    suspend fun update(cake: Cake)

    @Insert
    suspend fun insert(cake: Cake)

    @Delete
    suspend fun delete(cake: Cake)
}
