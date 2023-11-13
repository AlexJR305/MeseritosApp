package com.example.appmeseritos.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.appmeseritos.data.database.entities.comida
import com.example.appmeseritos.data.database.entities.cuenta
import com.example.appmeseritos.data.database.entities.empleados
import kotlinx.coroutines.flow.Flow

@Dao
interface cuentaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cuent: cuenta)

    @Update
    suspend fun update(item: cuenta)

    @Delete
    suspend fun delete(item: cuenta)

    @Query("SELECT * from cuanta_table WHERE id_Cuenta = :clave")
    fun getCuenta(clave: Int): Flow<cuenta>

    @Query("SELECT * from cuanta_table ORDER BY id_Cuenta ASC")
    fun getAllCuenta(): Flow<List<cuenta>>

}