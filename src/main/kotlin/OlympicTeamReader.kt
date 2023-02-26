import com.google.gson.Gson
import java.io.FileReader


/**
 * Class to read from JSON methods
 * @author Pavel Zilbershteyn
 * @constructor Empty
 */
class OlympicTeamReader {
    /**
     * Team will be read from JSON with [PATH]+filename
     * @param filename name of JSON file with Team
     * @return OlympicTeam object
     */
    fun readTeamFromJSON(filename: String): OlympicTeam {
        return Gson().fromJson(FileReader(PATH+filename), OlympicTeam::class.java)
    }

    private companion object {
        const val PATH = "src/main/resources/testData/"
    }
}