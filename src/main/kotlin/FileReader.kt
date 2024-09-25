package org.example

import java.io.File

class FileReader {



    fun readFile(file: File): List<String>{
        var contenido: List<String> = emptyList()
        if (file.exists()){
             contenido = file.useLines { it.toList() }
        }
        return contenido
    }


    fun extraerDatos(contenido: List<String>): MutableList<Map<String, List<String>>> {

        var linea = 1
        val datos = mutableListOf<Map<String,List<String>>>()
        while (linea < contenido.size){
            var cont = 0
            val contenidoLinea = contenido[linea].split(";")
            var nombreEmpresa = ""
            val listaContabilidad = mutableListOf<String>()
            while (cont < contenidoLinea.size){
                if (cont == 0){
                    nombreEmpresa = contenidoLinea[cont]
                }
                else{
                    listaContabilidad.add(contenidoLinea[cont])
                }
                cont++
            }
            datos.add(mapOf(Pair(nombreEmpresa, listaContabilidad.toList())))
            linea++
        }

        return datos
    }



    fun guardarDatos(fichero: File, datos: MutableList<Map<String, List<String>>> ){

        datos.forEach {empresa ->
            fichero.appendText("${empresa.keys};${empresa.values.toList()[0][1].replace(",",".").toDouble()};${empresa.values.toList()[0][2].replace(",",".").toDouble()};${(empresa.values.toList()[0][1].replace(",",".").toDouble())+(empresa.values.toList()[0][2].replace(",",".").toDouble())/2}\n")
        }


    }
}