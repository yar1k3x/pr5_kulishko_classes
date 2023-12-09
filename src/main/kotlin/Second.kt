import kotlin.math.pow
import kotlin.math.sqrt

// Функция для вычисления расстояния между двумя точками
fun calculateDistance(point1: Point, point2: Point): Double {
    // Используется формула расстояния между двумя точками в двумерном пространстве
    return kotlin.math.sqrt((point1.x - point2.x).pow(2) + (point1.y - point2.y).pow(2))
}

