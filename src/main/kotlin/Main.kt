package org.example

import java.io.File

fun main() {

    val userDir = System.getProperty("user.dir")

    val ficheroCotizacion = File("$userDir\\src\\main\\resources\\cotizacion.csv")

    val lectorDeFicheros = FileReader()
    val contenido = lectorDeFicheros.readFile(ficheroCotizacion)
    val desglose = lectorDeFicheros.extraerDatos(contenido)
    println(desglose)



    val  nuevoFichero = File("$userDir\\src\\main\\resources\\cotizacion2.csv")
    if (!nuevoFichero.exists()){
        nuevoFichero.createNewFile()
    }
    lectorDeFicheros.guardarDatos(nuevoFichero, desglose)
}