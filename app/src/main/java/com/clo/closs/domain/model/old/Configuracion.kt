package com.clo.closs.domain.model.old

import com.clo.closs.data.local.entities.old.ConfiguracionEntity

data class Configuracion(
    val cnfgActiva: Double = 0.0,
    val cnfgClase: String = "",
    val cnfgEtiq: String = "",
    val cnfgIdconfig: String = "",
    val cnfgLentxt: Double = 0.0,
    val cnfgTipo: String = "",
    val cnfgTtip: String? = "",
    val cnfgValfch: String = "",
    val cnfgValnum: Double = 0.0,
    val cnfgValsino: Double = 0.0,
    val cnfgValtxt: String? = "",
    val fechamodifi: String = "",
    val username: String = ""
) {
    fun toDataBase() = ConfiguracionEntity(
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
