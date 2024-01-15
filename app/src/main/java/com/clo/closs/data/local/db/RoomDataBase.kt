package com.clo.closs.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clo.closs.common.Constantes.DATABASE_VERSION_NEW
import com.clo.closs.data.local.dao.ProductDao
import com.clo.closs.data.local.dao.UserDao
import com.clo.closs.data.local.entities.ProductEntity
import com.clo.closs.data.local.entities.UserEntity

@Database(
    entities = [
        UserEntity::class,
        ProductEntity::class,
    ],
    version = DATABASE_VERSION_NEW,
    exportSchema = true
)
abstract class RoomDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun productDao(): ProductDao

    /*abstract fun gerenciaDao(): GerenciaDao

    abstract fun vendedorDao(): VendedorDao

    abstract fun estadisticaDao(): EstadisticaDao

    abstract fun clienteDao(): ClienteDao

    abstract fun pedidoDao(): PedidoDao

    abstract fun facturaDao(): FacturaDao

    abstract fun datosPedidosDao(): DatosPedidoDao

    abstract fun datosFacturasDao(): DatosFacturasDao

    abstract fun imagenDao(): ImagenDao

    abstract fun tasasDao(): TasasDao

    abstract fun configuracionDao(): ConfiguracionDao*/
}
