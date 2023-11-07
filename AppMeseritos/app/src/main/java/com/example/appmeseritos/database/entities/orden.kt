package com.example.appmeseritos.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Orden_table")
data class orden (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_Orden") val id_Orden:Int = 0,
    @ColumnInfo(name = "idComida")val idComida:Int,
    @ColumnInfo(name = "idCuenta")val idCuenta:Int,
    @ColumnInfo(name = "descripcion")val descripcion:String
)