package generators

import OlympicTeam
import com.google.gson.GsonBuilder
import java.io.FileWriter


class OlympicTeamGenerator {
    fun generateTeam(size: Int): OlympicTeam {
        val team = OlympicTeam()
        repeat(size) {
            team += SportsmanGenerator().generateSportsman()
        }
        return team
    }

    fun generateTeamAndWriteToJSON(size: Int): OlympicTeam {
        val olympicTeam = generateTeam(size)
        FileWriter("src/main/resources/testData/$size.json").use { writer ->
            val gsonPretty = GsonBuilder().setPrettyPrinting().create()
            gsonPretty.toJson(olympicTeam, writer)
        }

        return olympicTeam
    }

    fun generateTeamsOfDifferentSizes(sizes: Array<Int> = arrayOf(100, 500, 1000, 5000, 10000, 50000, 100000)) {
        sizes.forEach { OlympicTeamGenerator().generateTeamAndWriteToJSON(it) }
    }
}