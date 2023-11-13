package com.example.appmeseritos.database.Offline

import com.example.appmeseritos.data.database.dao.comidaDao
import com.example.appmeseritos.data.database.dao.cuentaDao
import com.example.appmeseritos.data.database.entities.comida
import com.example.appmeseritos.data.database.entities.cuenta
import com.example.appmeseritos.data.database.entities.empleados
import com.example.appmeseritos.database.Repository.ComidaRepository
import com.example.appmeseritos.database.Repository.CuentaRepository
import kotlinx.coroutines.flow.Flow

class OfflineCuenta (private val cuenDao: cuentaDao): CuentaRepository {
    override fun getAllCuentaStream(): Flow<List<cuenta>> = cuenDao.getAllCuenta()
    override fun getCuentaStream(id: Int): Flow<cuenta?> = cuenDao.getCuenta(id)

    override suspend fun insertCuenta(com: cuenta) = cuenDao.insert(com)

    override suspend fun deleteCuenta(com: cuenta) = cuenDao.delete(com)

    override suspend fun updateCuenta(com: cuenta) = cuenDao.update(com)
}