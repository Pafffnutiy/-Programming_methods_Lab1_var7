import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertEquals


class DifferentSortsTest {

    @ParameterizedTest
    @ValueSource(ints = [100, 100000])
    @DisplayName("Проверка сортировки простыми вставками")
    fun testSortBySimpleInserts(size: Int) {
        val team = OlympicTeamReader().readTeamFromJSON("$size.json")
        val customSortedTeam = team.sortSimpleInserts()
        val programSortedTeam = team.sort()

        assertEquals(programSortedTeam, customSortedTeam)
    }

    @ParameterizedTest
    @ValueSource(ints = [100, 100000])
    @DisplayName("Проверка пирамидальной сортировки")
    fun checkSortByPyramidSort(size: Int) {
        val team = OlympicTeamReader().readTeamFromJSON("$size.json")
        val customSortedTeam = team.sortPyramid()
        val programSortedTeam = team.sort()

        assertEquals(programSortedTeam, customSortedTeam)
    }

    @ParameterizedTest
    @ValueSource(ints = [100, 100000])
    @DisplayName("Проверка быстрой сортировки")
    fun checkSortByQuickSort(size: Int) {
        val team = OlympicTeamReader().readTeamFromJSON("$size.json")
        val customSortedTeam = team.sortQuick()
        val programSortedTeam = team.sort()

        assertEquals(programSortedTeam, customSortedTeam)
    }
}