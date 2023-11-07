package com.example.appmeseritos.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Comida_table")
data class comida (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_Comida") val id_Comida:Int = 0,
    @ColumnInfo(name = "nombre")val nombre:String,
    @ColumnInfo(name = "precio")val precio:Double,
    @ColumnInfo(name = "descripcion")val descripcion:String,
    @ColumnInfo(name = "url_Imagen")val url_Imagen:String,
    @ColumnInfo(name = "estatus")val estatus:Boolean
)