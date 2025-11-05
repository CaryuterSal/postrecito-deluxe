package mx.edu.utez.postrecitodeluxe.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mx.edu.utez.postrecitodeluxe.data.CakeDao
import mx.edu.utez.postrecitodeluxe.data.model.Cake

@Database(entities = [Cake::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cakeDao(): CakeDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app.db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}