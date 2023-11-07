package com.example.appmeseritos.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appmeseritos.data.database.entities.orden

@Dao
interface ordenDao {

    @Query("SELECT*FROM Orden_table")
    suspend fun getAllOrden():List<ordenDao>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(comidas:List<orden>)

    @Query("DELETE FROM Orden_table WHERE id_Orden = :id")
    suspend fun deleteById(id: Int)

    @Query("SELECT*FROM Orden_table WHERE id_Orden = :id")
    suspend fun getElementbyId(id: Int): orden
}