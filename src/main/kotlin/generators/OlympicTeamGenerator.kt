package generators

import OlympicTeam
import com.google.gson.GsonBuilder
import java.io.FileWriter


/**
 * Olympic Team Generation class
 * @author Pavel Zilbershteyn
 * @constructor Empty
 */
class OlympicTeamGenerator {
    /**
     * Generate olympic team with required size
     * @param size size of generated team
     * @return generated OlympicTeam object
     */
    fun generateTeam(size: Int): OlympicTeam {
        val team = OlympicTeam()
        repeat(size) {
            team += SportsmanGenerator().generateSportsman()
        }
        return team
    }

    /**
     * Generate olympic team with required size and write
     * to JSON with path "src/main/resources/testData/$size.json"
     * @param size size of generated team
     * @return generated OlympicTeam object
     */
    fun generateTeamAndWriteToJSON(size: Int): OlympicTeam {
        val olympicTeam = generateTeam(size)
        FileWriter("src/main/resources/testData/$size.json").use { writer ->
            val gsonPretty = GsonBuilder().setPrettyPrinting().create()
            gsonPretty.toJson(olympicTeam, writer)
        }

        return olympicTeam
    }

    /**
     * Generate olympic teams with required sizes and
     * write to JSON with path
     * "src/main/resources/testData/$size.json"
     * @param sizes array of team size as Int
     * @return Unit
     */
    fun generateTeamsOfDifferentSizes(sizes: Array<Int> = arrayOf(100, 500, 1000, 5000, 10000, 50000, 100000)) {
        sizes.forEach { OlympicTeamGenerator().generateTeamAndWriteToJSON(it) }
    }
}