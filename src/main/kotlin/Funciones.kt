/*Calcula dónde estará el robot R2D2 (sus coordenadas finales) que se encuentra en una cuadrícula
representada por los ejes "x" e "y".

El robot siempre comienza en la coordenada (0, 0).
Para indicarle que se mueva, le enviamos un array formado por enteros (positivos o negativos)
que indican la secuencia de pasos a dar.
Por ejemplo: [10, 5, -2] indica que primero se mueve 10 pasos, se detiene, luego 5, se detiene,
y finalmente 2 y se detiene.
El resultado en este caso sería (x: -5, y: 12)
Si el número de pasos es negativo, se desplazaría en sentido contrario al que está mirando.
Los primeros pasos los hace en el eje "y".
Interpretamos que inicialmente siempre está mirando hacia la parte positiva del eje "y".
El robot tiene un fallo en su programación: cada vez que finaliza una secuencia de pasos y se detiene,
gira 90 grados en el sentido contrario a las agujas del reloj.
En la entrega, adjunta la URL a tu repositorio.

Crea un nuevo proyecto en Intellij Idea que se llame R2D2.
Debes crear una función que reciba los movimientos y retorne el valor de x, y,
junto con el texto de la dirección en la que ha quedado R2D2 después de ejecutar los movimientos.
En la función main() se pide que realices las llamadas a la función anterior con los movimientos que
se incluyen en el punto 5.
La información que retorna dicha función, que mueve el robot, debe ser mostrada después de su llamada
en el propio main():*/

/*El programa debe ser capaz de resolver los movimientos siguientes:
[10, 5, -2]
[0, 0, 0]
[]
[-10, -5, 2]
[-10, -5, 2, 4, -8]
Las salidas que el programa debe calcular y mostrar son las siguientes:
x: -5, y: 12, direction: POSITIVEX
x: 0, y: 0, direction: POSITIVEX
x: 0, y: 0, direction: POSITIVEY
x: 5, y: -12, direction: POSITIVEX
x: 9, y: -20, direction: NEGATIVEX*/


fun askForNumber(): Any {
    val numberString = readln()
    try {
        val number = numberString.toInt()
        return number
    } catch (e: NumberFormatException) {
        return Unit
    }
}


fun askForMovements(): MutableList<Int> {
    println("Esto es el menú de movimiento de R2D2, introduce la cantidad de pasos separados por ENTER")
    val orderOfSteps: MutableList<Int> = mutableListOf()
    var isStepsANumber = true

    while (isStepsANumber) {
        print("Introduce un numero para añadirlo o cualquier otra cosa para finalizar -> ")
        val steps = askForNumber()

        if (steps !is Unit) {
            orderOfSteps.add(steps as Int)
        } else {
            isStepsANumber = false
        }
    }

    return orderOfSteps
}


fun initializeRobotPositionX(): Int {
    return 0
}


fun initializeRobotPositionY(): Int {
    return 0
}


fun initializeRobotDirection(): String {
    return "POSITIVEY"
}


fun moveRobot(movs: MutableList<Int>): List<Any> {
    var positionY = initializeRobotPositionY()
    var positionX = initializeRobotPositionX()
    var direction = initializeRobotDirection()

    for (steps in movs) {
        when (direction) {
            "POSITIVEY" -> {
                positionY += steps
                direction = "NEGATIVEX"
            }
            "NEGATIVEY" -> {
                positionY -= steps
                direction = "POSITIVEX"
            }
            "POSITIVEX" -> {
                positionX += steps
                direction = "POSITIVEY"
            }
            "NEGATIVEX" -> {
                positionX -= steps
                direction = "NEGATIVEY"
            }
        }
    }

    return listOf(positionX, positionY, direction)
}


fun showFinalRobotInfo(info: List<Any>) {
    val posX = info[0]
    val posY = info[1]
    val direct = info[2]

    println("x: %d, y: %d, direction: %s".format(posX, posY, direct))
}