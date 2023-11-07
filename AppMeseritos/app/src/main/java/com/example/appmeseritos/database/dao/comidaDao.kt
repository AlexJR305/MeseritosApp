package com.example.appmeseritos.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appmeseritos.data.database.entities.comida

@Dao
interface comidaDao {

    @Query("SELECT*FROM Comida_table")
    suspend fun getAllComida():List<comida>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(comidas:List<comida>)

    @Query("DELETE FROM Comida_table WHERE id_Comida = :id")
    suspend fun deleteById(id: Int)

    @Query("SELECT*FROM Comida_table WHERE id_Comida = :id")
    suspend fun getElementbyId(id: Int): comida
}