package com.example.appmeseritos.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Empleados_table")
data class empleados (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_Empleado") val id_Empleado:Int = 0,
    @ColumnInfo(name = "nombre")val nombre:String,
    @ColumnInfo(name = "apellidos")val apellidos:String,
    @ColumnInfo(name = "RFC")val RFC:String,
    @ColumnInfo(name = "telefono")val telefono:String,
    @ColumnInfo(name = "puesto")val puesto:Int,
    @ColumnInfo(name = "clave")val clave:String,
    @ColumnInfo(name = "contrasena")val contrasena:String,
    @ColumnInfo(name = "activo")val activo:Boolean,
    @ColumnInfo(name = "url_img")var url_img:String
)