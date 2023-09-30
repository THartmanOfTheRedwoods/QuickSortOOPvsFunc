fun quickSort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    } else {
        val pivot = list.first()
        val sortedSmaller = quickSort(list.drop(1).filter { it <= pivot })
        val sortedGreater = quickSort(list.drop(1).filter { it > pivot })

        return sortedSmaller + pivot + sortedGreater
    }
}

fun main() {
    val unsortedList = listOf(5, 1, 9, 3, 7, 6)
    println("Unsorted List: $unsortedList")

    val startTime = System.nanoTime()
    val sortedList = quickSort(unsortedList)
    val endTime = System.nanoTime()

    val executionTime = (endTime - startTime) / 1e6 // Convert to milliseconds

    println("Sorted List: $sortedList")
    println("Execution Time: $executionTime ms")
}
