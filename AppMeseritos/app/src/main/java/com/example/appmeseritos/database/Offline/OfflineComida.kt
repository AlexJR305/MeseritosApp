package com.example.appmeseritos.database.Offline

import com.example.appmeseritos.data.database.dao.comidaDao
import com.example.appmeseritos.data.database.dao.empleadosDao
import com.example.appmeseritos.data.database.entities.comida
import com.example.appmeseritos.data.database.entities.empleados
import com.example.appmeseritos.database.Repository.ComidaRepository
import com.example.appmeseritos.database.Repository.EmpleadosRepository
import kotlinx.coroutines.flow.Flow

class OfflineComida (private val comDao: comidaDao): ComidaRepository {
    override fun getAllComidaStream(): Flow<List<comida>> = comDao.getAllComidas()
    override fun getComidaStream(id: Int): Flow<comida?> = comDao.getComida(id)

    override suspend fun insertComida(com: comida) = comDao.insert(com)

    override suspend fun deleteComida(com: comida) = comDao.delete(com)

    override suspend fun updateComida(com: comida) = comDao.update(com)
}