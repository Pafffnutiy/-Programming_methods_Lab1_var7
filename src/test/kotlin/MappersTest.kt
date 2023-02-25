import com.google.gson.Gson
import databasesMappers.NamesDatabase
import databasesMappers.SportsDatabase
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.FileReader
import kotlin.test.assertEquals


class MappersTest {

    @Test
    @DisplayName("Проверка маппера базы данных с именами")
    fun testNamesDatabaseMapper() {
        val namesDatabase: NamesDatabase = Gson().fromJson(FileReader(NAMES_DATABASE_PATH), NamesDatabase::class.java)

        assertEquals(namesDatabase.maleFirstNames.size, 52)
        assertEquals(namesDatabase.maleFirstNames.first(), "Александр")
        assertEquals(namesDatabase.maleFirstNames.last(), "Ярослав")

        assertEquals(namesDatabase.maleMiddleNames.size, 52)
        assertEquals(namesDatabase.maleMiddleNames.first(), "Александрович")
        assertEquals(namesDatabase.maleMiddleNames.last(), "Ярославович")

        assertEquals(namesDatabase.maleLastNames.size, 250)
        assertEquals(namesDatabase.maleLastNames.first(), "Смирнов")
        assertEquals(namesDatabase.maleLastNames.last(), "Туров")

        assertEquals(namesDatabase.femaleFirstNames.size, 56)
        assertEquals(namesDatabase.femaleFirstNames.first(), "Анна")
        assertEquals(namesDatabase.femaleFirstNames.last(), "Юлия")

        assertEquals(namesDatabase.femaleMiddleNames.size, 51)
        assertEquals(namesDatabase.femaleMiddleNames.first(), "Александровна")
        assertEquals(namesDatabase.femaleMiddleNames.last(), "Ярославовна")

        assertEquals(namesDatabase.femaleLastNames.size, 250)
        assertEquals(namesDatabase.femaleLastNames.first(), "Смирнова")
        assertEquals(namesDatabase.femaleLastNames.last(), "Турова")
    }

    @Test
    @DisplayName("Проверка маппера базы данных с видами спорта")
    fun testSportssDatabaseMapper() {
        val sportsDatabase: SportsDatabase = Gson().fromJson(FileReader(SPORTS_DATABASE_PATH), SportsDatabase::class.java)

        assertEquals(sportsDatabase.summerOlympics, summerOlympics)
    }

    private companion object {
        const val DATABASES_PATH = "src/main/resources/Databases"
        const val NAMES_DATABASE_PATH = "$DATABASES_PATH/NamesDatabase.json"
        const val SPORTS_DATABASE_PATH = "$DATABASES_PATH/SportsDatabase.json"

        val summerOlympics = listOf(
            "3x3 баскетбол", "Стрельба из лука", "Художественная гимнастика", "Синхронное плавание",
            "Легкая атлетика", "Бадминтон", "Бейзбол", "Баскетбол", "Пляжный волейбол", "BMX фристайл",
            "BMX", "Бокс", "Гребля на байдарках и каноэ", "Гребной слалом", "Прыжки в воду", "Выездка",
            "Конкур", "Футбол", "Гольф", "Гандбол", "Хоккей", "Дзюдо", "Карате", "Плавание",
            "Современный пентатлон", "Маунтинбайк", "Спортивная гимнастика", "Шоссейный велоспорт",
            "Гребля", "Регби", "Парусный спорт", "Стрельба", "Скейтбоардинг", "Софтбол",
            "Спортивное скалолазание", "Серфинг", "Плавание на открытой воде", "Настольный теннис",
            "Тхэквондо", "Теннис", "Трековый велоспорт", "Прыжки на батуте", "Триатлон", "Воллейбол",
            "Водное поло", "Тяжелая атлетика", "Борьба"
        )
    }
}