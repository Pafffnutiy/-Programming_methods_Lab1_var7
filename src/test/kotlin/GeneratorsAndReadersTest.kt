import generators.OlympicTeamGenerator
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals


class GeneratorsAndReadersTest {

    @Test
    @DisplayName("Проверка работы ридера, генератора и райтера в JSON олимпийской команды")
    fun testOlympicTeamGeneratorAndReader() {
        val generatedTeam = OlympicTeamGenerator().generateTeamAndWriteToJSON(TEAM_SIZE)
        val readTeam = OlympicTeamReader().readTeamFromJSON(FILENAME)

        assertEquals(generatedTeam, readTeam)
    }

    @AfterEach
    fun deleteJSON() {
        File(PATH + FILENAME).delete()
    }

    private companion object {
        const val TEAM_SIZE = 1
        const val FILENAME = "$TEAM_SIZE.json"
        const val PATH = "src/main/resources/testData/"
    }
}