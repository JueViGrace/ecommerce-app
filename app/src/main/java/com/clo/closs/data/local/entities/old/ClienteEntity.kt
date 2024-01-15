package com.clo.closs.data.local.entities.old

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.clo.closs.domain.model.old.Cliente

// Data Class que representa la tabla de clientes
@Entity(tableName = "cliempre", indices = [Index(value = ["codigo"], unique = true)])
data class ClienteEntity(
    @ColumnInfo(name = "cantdocs") val cantdocs: Double,
    @PrimaryKey val codigo: String,
    @ColumnInfo(name = "contribespecial") val contribespecial: Double,
    @ColumnInfo(name = "diasultvta") val diasultvta: Double,
    @ColumnInfo(name = "direccion") val direccion: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "fchcrea") val fchcrea: String,
    @ColumnInfo(name = "fchultvta") val fchultvta: String,
    @ColumnInfo(name = "fechamodifi") val fechamodifi: String,
    @ColumnInfo(name = "kneActiva") val kneActiva: String,
    @ColumnInfo(name = "kneMtomin") val kneMtomin: Double,
    @ColumnInfo(name = "limcred") val limcred: Double,
    @ColumnInfo(name = "mtoultvta") val mtoultvta: Double,
    @ColumnInfo(name = "noemifac") val noemifac: Int,
    @ColumnInfo(name = "noeminota") val noeminota: Int,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "perscont") val perscont: String,
    @ColumnInfo(name = "prcdpagdia") val prcdpagdia: Double,
    @ColumnInfo(name = "precio") val precio: Double,
    @ColumnInfo(name = "promdiasp") val promdiasp: Double,
    @ColumnInfo(name = "promdiasvta") val promdiasvta: Double,
    @ColumnInfo(name = "prommtodoc") val prommtodoc: Double,
    @ColumnInfo(name = "riesgocrd") val riesgocrd: Double,
    @ColumnInfo(name = "sector") val sector: String,
    @ColumnInfo(name = "status") val status: Double,
    @ColumnInfo(name = "subcodigo") val subcodigo: String,
    @ColumnInfo(name = "telefonos") val telefonos: String,
    @ColumnInfo(name = "totmtodocs") val totmtodocs: Double,
    @ColumnInfo(name = "vendedor") val vendedor: String
) {
    // Función de extensión para mapear los datos de la tabla al modelo de dominio
    fun toDomain() = Cliente(
        cantdocs = cantdocs,
        codigo = codigo,
        contribespecial = contribespecial,
        diasultvta = diasultvta,
        direccion = direccion,
        email = email,
        fchcrea = fchcrea,
        fchultvta = fchultvta,
        fechamodifi = fechamodifi,
        kneActiva = kneActiva,
        kneMtomin = kneMtomin,
        limcred = limcred,
        mtoultvta = mtoultvta,
        noemifac = noemifac,
        noeminota = noeminota,
        nombre = nombre,
        perscont = perscont,
        prcdpagdia = prcdpagdia,
        precio = precio,
        promdiasp = promdiasp,
        promdiasvta = promdiasvta,
        prommtodoc = prommtodoc,
        riesgocrd = riesgocrd,
        sector = sector,
        status = status,
        subcodigo = subcodigo,
        telefonos = telefonos,
        totmtodocs = totmtodocs,
        vendedor = vendedor,
    )
}
