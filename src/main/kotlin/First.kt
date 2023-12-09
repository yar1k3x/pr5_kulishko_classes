import kotlin.math.abs

// Класс для представления треугольника
class Triangle(val pointA: Point, val pointB: Point, val pointC: Point) {

    // Функция для проверки, находится ли точка внутри треугольника
    fun isPointInsideTriangle(point: Point): Boolean {
        val totalArea = calculateArea(pointA, pointB, pointC)
        val firstArea = calculateArea(point, pointB, pointC)
        val secondArea = calculateArea(pointA, point, pointC)
        val thirdArea = calculateArea(pointA, pointB, point)

        // Проверка нахождения точки внутри треугольника с учетом погрешности
        return abs(totalArea - (firstArea + secondArea + thirdArea)) < 1e-9
    }

    // Функция для вычисления площади треугольника по формуле Герона
    private fun calculateArea(point1: Point, point2: Point, point3: Point): Double {
        return 0.5 * abs(point1.x * (point2.y - point3.y) +
                point2.x * (point3.y - point1.y) +
                point3.x * (point1.y - point2.y)
        )
    }
}

// Функция для создания точки с вводом координат с консоли
fun readPointFromConsole(): Point {
    println("Введите координату X:")
    val x = readLine()?.toDoubleOrNull() ?: 0.0

    println("Введите координату Y:")
    val y = readLine()?.toDoubleOrNull() ?: 0.0

    return Point(x, y)
}

