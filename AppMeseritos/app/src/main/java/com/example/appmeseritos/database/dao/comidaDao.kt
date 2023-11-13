package com.example.appmeseritos.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.appmeseritos.data.database.entities.comida
import com.example.appmeseritos.data.database.entities.empleados
import kotlinx.coroutines.flow.Flow

@Dao
interface comidaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(co: comida)

    @Update
    suspend fun update(item: comida)

    @Delete
    suspend fun delete(item: comida)

    @Query("SELECT * from comida_table WHERE id_Comida = :clave")
    fun getComida(clave: Int): Flow<comida>

    @Query("SELECT * from comida_table ORDER BY nombre ASC")
    fun getAllComidas(): Flow<List<comida>>
}