import java.io.File
import kotlin.system.measureTimeMillis


val sizes = listOf(100, 500, 1000, 5000, 10000, 50000, 100000)

fun main() {
    File("src/main/resources/time.txt").printWriter().use { writer ->

        fun sortAllBySimpleInserts() {
            writer.println("Sort by simple inserts:")
            for (size in sizes) {
                val team = OlympicTeamReader().readTeamFromJSON("$size.json")
                val sortedTeam: OlympicTeam
                val timeToSort = measureTimeMillis { sortedTeam = team.sortSimpleInserts() }

                writer.println("\t$size: ${timeToSort}ms")

                sortedTeam.writeTeamToJSON("sortedBySimpleInserts/$size.json")
            }
        }

        fun sortAllByQuickSort() {
            writer.println("\nQuick sort:")
            for (size in sizes) {
                val team = OlympicTeamReader().readTeamFromJSON("$size.json")
                val sortedTeam: OlympicTeam
                val timeToSort = measureTimeMillis { sortedTeam = team.sortQuick() }

                writer.println("\t$size: ${timeToSort}ms")

                sortedTeam.writeTeamToJSON("sortedByQuickSort/$size.json")
            }
        }

        fun sortAllByPyramidSort() {
            writer.println("\nPyramid sort:")
            for (size in sizes) {
                val team = OlympicTeamReader().readTeamFromJSON("$size.json")
                val sortedTeam: OlympicTeam
                val timeToSort = measureTimeMillis { sortedTeam = team.sortPyramid() }

                writer.println("\t$size: ${timeToSort}ms")

                sortedTeam.writeTeamToJSON("sortedByPyramidSort/$size.json")
            }
        }


        sortAllBySimpleInserts()
        sortAllByQuickSort()
        sortAllByPyramidSort()
    }
}