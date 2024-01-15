package com.clo.closs.data.local.entities.old

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clo.closs.domain.model.old.Estadistica

// Data Class que representa la tabla de estadística
@Entity(tableName = "ke_estadc01")
data class EstadisticaEntity(
    @ColumnInfo(name = "clivisit") val clivisit: Double,
    @ColumnInfo(name = "cntclientes") val cntclientes: Double,
    @ColumnInfo(name = "cntfacturas") val cntfacturas: Double,
    @ColumnInfo(name = "cntpedidos") val cntpedidos: Double,
    @ColumnInfo(name = "cntrecl") val cntrecl: Double,
    @ColumnInfo(name = "codcoord") val codcoord: String,
    @ColumnInfo(name = "defdolTotneto") val defdolTotneto: Double,
    @ColumnInfo(name = "devdolTotneto") val devdolTotneto: Double,
    @ColumnInfo(name = "fechaEstad") val fechaEstad: String,
    @ColumnInfo(name = "lomMontovtas") val lomMontovtas: Double,
    @ColumnInfo(name = "lomPrcvisit") val lomPrcvisit: Double,
    @ColumnInfo(name = "lomPrcvtas") val lomPrcvtas: Double,
    @ColumnInfo(name = "mtofacturas") val mtofacturas: Double,
    @ColumnInfo(name = "mtopedidos") val mtopedidos: Double,
    @ColumnInfo(name = "mtorecl") val mtorecl: Double,
    @ColumnInfo(name = "metavend") val metavend: Double,
    @ColumnInfo(name = "nombrevend") val nombrevend: String,
    @ColumnInfo(name = "nomcoord") val nomcoord: String,
    @ColumnInfo(name = "ppgdolTotneto") val ppgdolTotneto: Double,
    @ColumnInfo(name = "prcmeta") val prcmeta: Double,
    @ColumnInfo(name = "prcvisitas") val prcvisitas: Double,
    @ColumnInfo(name = "rlomMontovtas") val rlomMontovtas: Double,
    @ColumnInfo(name = "rlomPrcvisit") val rlomPrcvisit: Double,
    @ColumnInfo(name = "rlomPrcvtas") val rlomPrcvtas: Double,
    @ColumnInfo(name = "totdolcob") val totdolcob: Double,
    @PrimaryKey val vendedor: String
) {
    // Función de extensión para mapear los datos de la tabla al modelo de dominio
    fun toDomain() = Estadistica(
        clivisit = clivisit,
        cntclientes = cntclientes,
        cntfacturas = cntfacturas,
        cntpedidos = cntpedidos,
        cntrecl = cntrecl,
        codcoord = codcoord,
        defdolTotneto = defdolTotneto,
        devdolTotneto = devdolTotneto,
        fechaEstad = fechaEstad,
        lomMontovtas = lomMontovtas,
        lomPrcvisit = lomPrcvisit,
        lomPrcvtas = lomPrcvtas,
        mtofacturas = mtofacturas,
        mtopedidos = mtopedidos,
        mtorecl = mtorecl,
        metavend = metavend,
        nombrevend = nombrevend,
        nomcoord = nomcoord,
        ppgdolTotneto = ppgdolTotneto,
        prcmeta = prcmeta,
        prcvisitas = prcvisitas,
        rlomMontovtas = rlomMontovtas,
        rlomPrcvisit = rlomPrcvisit,
        rlomPrcvtas = rlomPrcvtas,
        totdolcob = totdolcob,
        vendedor = vendedor
    )
}
