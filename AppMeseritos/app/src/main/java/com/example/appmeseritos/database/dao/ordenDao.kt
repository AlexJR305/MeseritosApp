package com.example.appmeseritos.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.appmeseritos.data.database.entities.empleados
import com.example.appmeseritos.data.database.entities.orden
import kotlinx.coroutines.flow.Flow

@Dao
interface ordenDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(ord: orden)

    @Update
    suspend fun update(item: orden)

    @Delete
    suspend fun delete(item: orden)

    @Query("SELECT * from orden_table WHERE id_Orden = :clave")
    fun getOrden(clave: Int): Flow<orden>

    @Query("SELECT * from orden_table ORDER BY id_Orden ASC")
    fun getAllOrdenes(): Flow<List<orden>>
}