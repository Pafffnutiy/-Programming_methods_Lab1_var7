import com.google.gson.GsonBuilder
import java.io.FileWriter

/**
 * Class of OlympicTeam
 * @constructor create object by List of Sportsman
 * @author Pavel Zilbershteyn
 */
class OlympicTeam(var team: List<Sportsman> = listOf()) {
    /**
     * Overriding of operator += for case
     * OlympicTeam += Sportsman
     * @param sportsman
     * @return Unit
     */
    operator fun plusAssign(sportsman: Sportsman) {
        team += sportsman
    }

    /**
     * Overriding of operator + for case
     * OlympicTeam + Sportsman
     * @param sportsman
     * @return OlympicTeam
     */
    operator fun plus(sportsman: Sportsman): OlympicTeam {
        return OlympicTeam(team + sportsman)
    }

    /**
     * Overriding of operator + for case
     * OlympicTeam + OlympicTeam
     * @param otherTeam
     * @return OlympicTeam
     */
    operator fun plus(otherTeam: OlympicTeam): OlympicTeam {
        return OlympicTeam(team + otherTeam.team)
    }

    /**
     * Overriding of indexing operator []
     * @param index
     * @return Sportsman
     */
    operator fun get(index: Int): Sportsman = team[index]

    /**
     * Overriding of equals (==) between two OlympicTeam objects
     * If b isn't OlympicTeam returns false
     * @param other Any object
     * @return true if this.team==other.team
     * and false otherwise
     */
    override fun equals(other: Any?): Boolean {
        if (other !is OlympicTeam) return false
        return  team == other.team
    }

    /**
     * Kotlin sorting
     * @param Empty
     * @return sorted OlympicTeam
     */
    fun sort(): OlympicTeam {
        return OlympicTeam(team.sorted())
    }

    /**
     * Sorting by simple inserts
     * @param Empty
     * @return sorted OlympicTeam
     */
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

    /**
     * Pyramid sorting
     * @param Empty
     * @return sorted OlympicTeam
     */
    fun sortPyramid(): OlympicTeam {
        val sortedTeam = team
        val sortedTeamArray = sortedTeam.toTypedArray()
        var i = sortedTeam.size / 2 - 1
        while (i >= 0) {
            // build pyramid
            downHeap(sortedTeamArray, i, sortedTeamArray.size - 1)
            i--
        }
        // now a[0]...a[size-1] is a pyramid
        i = sortedTeamArray.size - 1
        while (i > 0) {
            sortedTeamArray[i] = sortedTeamArray[0].also {
                sortedTeamArray[0] = sortedTeamArray[i]
            }
            downHeap(sortedTeamArray, 0, i - 1) // restore the pyramid a[0]...a[i-1]
            i--
        }

        return OlympicTeam(sortedTeamArray.toList())
    }

    /**
     * Quick sorting
     * @param Empty
     * @return sorted OlympicTeam
     */
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

    /**
     * Writing team to JSON file "src/main/resources/[filename]"
     * @param filename name of JSON file
     * @return Unit
     */
    fun writeTeamToJSON(filename: String) {
        FileWriter("src/main/resources/$filename").use { writer ->
            val gsonPretty = GsonBuilder().setPrettyPrinting().create()
            gsonPretty.toJson(this, writer)
        }
    }

    /**
     * helper for Pyramid sorting
     * @param arr Array of Sportsmen
     * @param k start index
     * @param n end index
     * @return Unit
     */
    private fun downHeap(arr: Array<Sportsman>, k: Int, n: Int) {
        var child: Int
        val newElem = arr[k]
        var k1 = k

        while (k1 <= n / 2) {  // while a[k] has childs
            child = 2 * k1
            //  choose bigger son
            if (child < n && arr[child] < arr[child + 1])
                child++

            if (newElem >= arr[child]) break
            // otherwise
            arr[k1] = arr[child];    // move the son up
            k1 = child;
        }
        arr[k1] = newElem;
    }

    /**
     * Overriding hashCode fun
     * @param Empty
     * @return hashCode as Int
     */
    override fun hashCode(): Int {
        return team.hashCode()
    }

}