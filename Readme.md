# Procesador estadístico

## Descripción

La siguiente aplicación procesa un fichero de texto con datos sociodemográficos de personas y, a continuación, muestra por consola el resultado estadístico:

1. La media de edad de las personas del fichero
2. La diferencia en cantidad de hombres y mujeres
3. La diferencia de edad entre la mujer mayor y el hombre más joven
4. Si se han encontrado hermanos o no

## Metodología

* El desarrollo se ha realizado siguiendo los principios fundamentales de diseño y patrones OOP, con separación de responsabilidades de lectura, procesado y visualización de resultados. 
* Es importante comentar que se ha asumido que el fichero de entrada está con el formato correcto y __sin errores__. 
* Se ha optado por la NO utilización de ningún framework, ni librería debido a la simplicidad del enunciado y con objeto de focalizarnos en el control; la ligereza del aplicativo; la independencia respecto a terceros y la claridad del seguimiento de la programación (de cara a la revisión del ejercicio).
* El IDE utilizado es IntelliJIdea, v2019.2.3 para MacOS; con su Java SDK v11 incorporada. 

## Siguientes pasos

Como mejora del aplicativo añadiría los siguientes aspectos:

* Funcionalidad de añadir media de edad de los titulados (campo opcional del fichero)
* Tratamiento de errores en aquellos procesos en los que fuera necesario

## Entrada

Ejecutar el fichero .jar generado en _/out/artifacts/asaitecProject_jar/asaitecProject.jar_ pasándole como argumento la localización del fichero que se desee procesar. P.e:

_java asaitecProject.jar /Users/salva/IdeaProjects/asaitecProject/Personas.txt_

## Salida

![Salida por consola](/Output.png)
