package com.example.appmeseritos.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cuanta_table")
data class cuenta (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_Cuenta") val id_Cuenta:Int = 0,
    @ColumnInfo(name = "horaInicio")val horaInicio:Double,
    @ColumnInfo(name = "horaFin")val horaFin:Double,
    @ColumnInfo(name = "Total")val Total:Double,
    @ColumnInfo(name = "NumMesa")val NumMesa:Int
)