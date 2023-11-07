package com.example.appmeseritos.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appmeseritos.data.database.entities.cuenta

@Dao
interface cuentaDao {

    @Query("SELECT*FROM Cuanta_table")
    suspend fun getAllCuentas():List<cuenta>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cuentas:List<cuenta>)

    @Query("DELETE FROM Cuanta_table WHERE id_Cuenta = :id")
    suspend fun deleteById(id: Int)

    @Query("SELECT*FROM Cuanta_table WHERE id_Cuenta = :id")
    suspend fun getElementbyId(id: Int): cuenta


}