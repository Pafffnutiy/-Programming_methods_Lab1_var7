import com.google.gson.Gson
import java.io.FileReader


class OlympicTeamReader {
    fun readTeamFromJSON(filename: String): OlympicTeam {
        return Gson().fromJson(FileReader(PATH+filename), OlympicTeam::class.java)
    }

    private companion object {
        const val PATH = "src/main/resources/testData/"
    }
}