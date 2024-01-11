fun main() {
    println("Bienvenido al panel de control de R2D2")
    var repeat = true

    while (repeat) {
        val movements = askForMovements()
        val infoFinal = moveRobot(movements)
        showFinalRobotInfo(infoFinal)

        Thread.sleep(2000)
        print("\nIntroduce (Y) para volver a controlar a R2D2, cualquier otra cosa cerrará el programa: ")
        val userCommand = readln().uppercase()
        if (userCommand != "Y"){
            repeat = false
        }
    }
}