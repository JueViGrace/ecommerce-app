package com.clo.closs.data.local.entities.old

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clo.closs.domain.model.old.Gerencia

// Data Class que representa la tabla de gerencias
@Entity(tableName = "ke_nivgcia")
data class GerenciaEntity(
    @ColumnInfo(name = "fechamodifi") val fechamodifi: String,
    @PrimaryKey val kngCodcoord: String,
    @ColumnInfo(name = "kngCodgcia") val kngCodgcia: String
) {
    // Función de extensión para mapear los datos de la tabla al modelo de dominio
    fun toDomain() = Gerencia(
        fechamodifi = fechamodifi,
        kngCodcoord = kngCodcoord,
        kngCodgcia = kngCodgcia
    )
}
