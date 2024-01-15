package com.clo.closs.data.local.entities.old

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clo.closs.domain.model.old.Configuracion

// Data Class que representa la tabla de configuración
@Entity(
    tableName = "configuracion"
)
data class ConfiguracionEntity(
    @ColumnInfo(name = "cnfgActiva") val cnfgActiva: Double,
    @ColumnInfo(name = "cnfgClase") val cnfgClase: String,
    @PrimaryKey val cnfgEtiq: String,
    @ColumnInfo(name = "cnfgIdconfig") val cnfgIdconfig: String,
    @ColumnInfo(name = "cnfgLentxt") val cnfgLentxt: Double,
    @ColumnInfo(name = "cnfgTipo") val cnfgTipo: String,
    @ColumnInfo(name = "cnfgTtip") val cnfgTtip: String?,
    @ColumnInfo(name = "cnfgValfch") val cnfgValfch: String,
    @ColumnInfo(name = "cnfgValnum") val cnfgValnum: Double,
    @ColumnInfo(name = "cnfgValsino") val cnfgValsino: Double,
    @ColumnInfo(name = "cnfgValtxt") val cnfgValtxt: String?,
    @ColumnInfo(name = "fechamodifi") val fechamodifi: String,
    @ColumnInfo(name = "username") val username: String
) {
    // Función de extensión para mapear los datos de la tabla al modelo de dominio
    fun toDomain() = Configuracion(
        cnfgActiva = cnfgActiva,
        cnfgClase = cnfgClase,
        cnfgEtiq = cnfgEtiq,
        cnfgIdconfig = cnfgIdconfig,
        cnfgLentxt = cnfgLentxt,
        cnfgTipo = cnfgTipo,
        cnfgTtip = cnfgTtip,
        cnfgValfch = cnfgValfch,
        cnfgValnum = cnfgValnum,
        cnfgValsino = cnfgValsino,
        cnfgValtxt = cnfgValtxt,
        fechamodifi = fechamodifi,
        username = username
    )
}
