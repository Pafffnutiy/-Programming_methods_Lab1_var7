import generators.OlympicTeamGenerator
import java.io.File
import java.io.FileWriter
import java.util.Collections.swap
import kotlin.system.measureTimeMillis

val sizes = listOf(100, 500, 1000, 5000, 10000, 50000, 100000)

fun main() {
//    OlympicTeamGenerator().generateTeamAndWriteToJSON(6)
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


        sortAllBySimpleInserts()
        sortAllByQuickSort()
    }


}