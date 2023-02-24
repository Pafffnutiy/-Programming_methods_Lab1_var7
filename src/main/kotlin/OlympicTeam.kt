import com.google.gson.GsonBuilder
import java.io.FileWriter

class OlympicTeam(var team: List<Sportsman> = listOf()) {
    operator fun plusAssign(sportsman: Sportsman) {
        team += sportsman
    }

    operator fun plus(sportsman: Sportsman): OlympicTeam {
        return OlympicTeam(team + sportsman)
    }

    operator fun plus(otherTeam: OlympicTeam): OlympicTeam {
        return OlympicTeam(team + otherTeam.team)
    }

    operator fun get(index: Int) = team[index]

    fun sortSimpleInserts(): OlympicTeam {
        val sortedTeam = team.toMutableList()
        for (index in 1 until sortedTeam.size) {
            val value = sortedTeam[index]
            var subIndex = index - 1
            while (subIndex >= 0 && sortedTeam[subIndex] > value) {
                sortedTeam[subIndex + 1] = sortedTeam[subIndex]
                subIndex--
            }
            sortedTeam[subIndex + 1] = value
        }

        return OlympicTeam(sortedTeam)
    }

    fun sortPyramid() {

    }

    fun sortQuick(): OlympicTeam {
        val sortedTeam = team

        if (sortedTeam.size < 2) return this

        val pivot = sortedTeam[sortedTeam.size / 2]
        val equalToPivot = sortedTeam.filter { it == pivot }
        val lessThanPivot = sortedTeam.filter { it < pivot }
        val greaterThanPivot = sortedTeam.filter { it > pivot }

        return  OlympicTeam(lessThanPivot).sortQuick() +
                OlympicTeam(equalToPivot) +
                OlympicTeam(greaterThanPivot).sortQuick()
    }

    fun writeTeamToJSON(filename: String) {
        FileWriter("src/main/resources/$filename").use { writer ->
            val gsonPretty = GsonBuilder().setPrettyPrinting().create()
            gsonPretty.toJson(this, writer)
        }
    }
}