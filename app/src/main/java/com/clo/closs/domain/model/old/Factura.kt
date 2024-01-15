package com.clo.closs.domain.model.old

import com.clo.closs.data.local.entities.old.FacturaEntity

data class Factura(
    val aceptadev: String = "",
    val agencia: String = "",
    val bsflete: Double = 0.0,
    val bsiva: Double = 0.0,
    val bsmtofte: Double = 0.0,
    val bsmtoiva: Double = 0.0,
    val bsretencioniva: Double = 0.0,
    val cbsret: Double = 0.0,
    val cbsretflete: Double = 0.0,
    val cbsretiva: Double = 0.0,
    val cbsrparme: Double = 0.0,
    val cdret: Double = 0.0,
    val cdretflete: Double = 0.0,
    val cdretiva: Double = 0.0,
    val cdrparme: Double = 0.0,
    val codcliente: String = "",
    val codcoord: String = "",
    val contribesp: Double = 0.0,
    val dFlete: Double = 0.0,
    val diascred: Double = 0.0,
    val documento: String = "",
    val dretencion: Double = 0.0,
    val dretencioniva: Double = 0.0,
    val dtotalfinal: Double = 0.0,
    val dtotdescuen: Double = 0.0,
    val dtotdev: Double = 0.0,
    val dtotimpuest: Double = 0.0,
    val dtotneto: Double = 0.0,
    val dtotpagos: Double = 0.0,
    val dvndmtototal: Double = 0.0,
    val emision: String = "",
    val estatusdoc: String = "",
    val fchvencedcto: String = "",
    val fechamodifi: String = "",
    val ktiNegesp: String = "",
    val mtodcto: Double = 0.0,
    val nombrecli: String = "",
    val recepcion: String = "",
    val retmunMto: Double = 0.0,
    val rutaParme: String = "",
    val tasadoc: Double = 0.0,
    val tienedcto: String = "",
    val tipodoc: String = "",
    val tipodocv: String = "",
    val tipoprecio: Double = 0.0,
    val vence: String = "",
    val vendedor: String = ""
) {
    fun toDatabase() = FacturaEntity(
        aceptadev = aceptadev,
        agencia = agencia,
        bsflete = bsflete,
        bsiva = bsiva,
        bsmtofte = bsmtofte,
        bsmtoiva = bsmtoiva,
        bsretencioniva = bsretencioniva,
        cbsret = cbsret,
        cbsretflete = cbsretflete,
        cbsretiva = cbsretiva,
        cbsrparme = cbsrparme,
        cdret = cdret,
        cdretflete = cdretflete,
        cdretiva = cdretiva,
        cdrparme = cdrparme,
        codcliente = codcliente,
        codcoord = codcoord,
        contribesp = contribesp,
        dFlete = dFlete,
        diascred = diascred,
        documento = documento,
        dretencion = dretencion,
        dretencioniva = dretencioniva,
        dtotalfinal = dtotalfinal,
        dtotdescuen = dtotdescuen,
        dtotdev = dtotdev,
        dtotimpuest = dtotimpuest,
        dtotneto = dtotneto,
        dtotpagos = dtotpagos,
        dvndmtototal = dvndmtototal,
        emision = emision,
        estatusdoc = estatusdoc,
        fchvencedcto = fchvencedcto,
        fechamodifi = fechamodifi,
        ktiNegesp = ktiNegesp,
        mtodcto = mtodcto,
        nombrecli = nombrecli,
        recepcion = recepcion,
        retmunMto = retmunMto,
        rutaParme = rutaParme,
        tasadoc = tasadoc,
        tienedcto = tienedcto,
        tipodoc = tipodoc,
        tipodocv = tipodocv,
        tipoprecio = tipoprecio,
        vence = vence,
        vendedor = vendedor
    )
}
