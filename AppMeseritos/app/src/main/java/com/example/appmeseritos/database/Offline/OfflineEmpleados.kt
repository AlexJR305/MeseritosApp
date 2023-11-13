package com.example.appmeseritos.database.Offline

import com.example.appmeseritos.data.database.dao.empleadosDao
import com.example.appmeseritos.data.database.entities.empleados
import com.example.appmeseritos.database.Repository.EmpleadosRepository
import kotlinx.coroutines.flow.Flow

class OfflineEmpleados(private val empleadoDao: empleadosDao): EmpleadosRepository {
    override fun getAllEmpleadosStream():Flow<List<empleados>> = empleadoDao.getAllEmpleeados()
    override fun getEmpleadoStream(id: Int): Flow<empleados?> = empleadoDao.getEmpleado(id)

    override suspend fun insertEmpleado(empleado: empleados) = empleadoDao.insert(empleado)

    override suspend fun deleteEmpleado(empleado: empleados) = empleadoDao.delete(empleado)

    override suspend fun updateEmpleado(empleado: empleados) = empleadoDao.update(empleado)
}