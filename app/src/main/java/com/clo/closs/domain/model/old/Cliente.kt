package com.clo.closs.domain.model.old

import com.clo.closs.data.local.entities.old.ClienteEntity

data class Cliente(
    val cantdocs: Double = 0.0,
    val codigo: String = "",
    val contribespecial: Double = 0.0,
    val diasultvta: Double = 0.0,
    val direccion: String = "",
    val email: String = "",
    val fchcrea: String = "",
    val fchultvta: String = "",
    val fechamodifi: String = "",
    val kneActiva: String = "",
    val kneMtomin: Double = 0.0,
    val limcred: Double = 0.0,
    val mtoultvta: Double = 0.0,
    val noemifac: Int = 0,
    val noeminota: Int = 0,
    val nombre: String = "",
    val perscont: String = "",
    val prcdpagdia: Double = 0.0,
    val precio: Double = 0.0,
    val promdiasp: Double = 0.0,
    val promdiasvta: Double = 0.0,
    val prommtodoc: Double = 0.0,
    val riesgocrd: Double = 0.0,
    val sector: String = "",
    val status: Double = 0.0,
    val subcodigo: String = "",
    val telefonos: String = "",
    val totmtodocs: Double = 0.0,
    val vendedor: String = ""
) {
    fun toDatabase() = ClienteEntity(
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
