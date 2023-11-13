package com.example.appmeseritos.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.appmeseritos.data.database.entities.empleados
import kotlinx.coroutines.flow.Flow

@Dao
interface empleadosDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(empleado: empleados)

    @Update
    suspend fun update(item: empleados)

    @Delete
    suspend fun delete(item: empleados)

    @Query("SELECT * from empleados_table WHERE clave = :clave")
    fun getEmpleado(clave: Int): Flow<empleados>

    @Query("SELECT * from empleados_table ORDER BY nombre ASC")
    fun getAllEmpleeados(): Flow<List<empleados>>
}