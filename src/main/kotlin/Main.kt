import kotlin.math.pow
import kotlin.math.abs
import Triangle as Triangle

class Point(val x: Double, val y: Double) {

    fun readPointFromConsole(): Point {
        println("Введите координату X:")
        val x = readLine()?.toDoubleOrNull() ?: 0.0

        println("Введите координату Y:")
        val y = readLine()?.toDoubleOrNull() ?: 0.0

        return Point(x, y)
    }

    // Функция для вычисления расстояния между двумя точками
    fun calculateDistance(pointA: Point, pointB: Point): Double {
        return kotlin.math.sqrt((pointB.x - pointA.x).pow(2) + (pointB.y - pointA.y).pow(2))
    }
}
    // Функция для создания треугольника с вводом координат его вершин
    fun readTriangleFromConsole(): Triangle {
        println("Введите координаты вершин треугольника:")
        val vertexA = readPointFromConsole()
        val vertexB = readPointFromConsole()
        val vertexC = readPointFromConsole()

        return Triangle(vertexA, vertexB, vertexC)
    }

    fun checkPointInsideTriangle() {
        try {
            val point = readPointFromConsole()
            val triangle = readTriangleFromConsole()

            val result = if (triangle.isPointInsideTriangle(point)) "внутри" else "вне"
            println("Точка находится $result треугольника.")
        } catch (e: Exception) {
            println("Ошибка: ${e.message}")
        }
    }

    fun calculateDistanceBetweenPoints() {
        val pointA = readPointFromConsole()
        val pointB = readPointFromConsole()
        println("Расстояние между точками: ${calculateDistance(pointA, pointB)}")
    }

    fun findMinMaxDistancesBetweenPoints() {
        println("Введите количество точек: ")
        val pointCount = readLine()?.toIntOrNull() ?: 0
        val pointList = mutableListOf<Point>()
        for (i in 0 until pointCount) {
            pointList.add(readPointFromConsole())
        }

        var minDistance = Double.MAX_VALUE
        var maxDistance = Double.MIN_VALUE
        for (i in 0 until pointCount - 1) {
            for (j in i + 1 until pointCount) {
                val distance = calculateDistance(pointList[i], pointList[j])
                minDistance = minOf(minDistance, distance)
                maxDistance = maxOf(maxDistance, distance)
            }
        }
        println("Максимальное расстояние: $maxDistance; Минимальное расстояние: $minDistance ")
    }


// Функция для создания точки с вводом координат с консоли

fun main() {
    findMinMaxDistancesBetweenPoints()
}
