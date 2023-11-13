package com.example.appmeseritos.database.Offline

import com.example.appmeseritos.data.database.dao.empleadosDao
import com.example.appmeseritos.data.database.dao.ordenDao
import com.example.appmeseritos.data.database.entities.empleados
import com.example.appmeseritos.data.database.entities.orden
import com.example.appmeseritos.database.Repository.EmpleadosRepository
import com.example.appmeseritos.database.Repository.OrdenRepository
import kotlinx.coroutines.flow.Flow

class OfflineOrden (private val ordenesDao: ordenDao): OrdenRepository {
    override fun getAllOrdenStream(): Flow<List<orden>> = ordenesDao.getAllOrdenes()
    override fun getOrdenStream(id: Int): Flow<orden?> = ordenesDao.getOrden(id)

    override suspend fun insertOrden(item: orden) = ordenesDao.insert(item)

    override suspend fun deleteOrden(item: orden) = ordenesDao.delete(item)

    override suspend fun updateOrden(item: orden) = ordenesDao.update(item)
}