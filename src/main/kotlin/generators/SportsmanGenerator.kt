package generators

import databasesMappers.NamesDatabase
import databasesMappers.SportsDatabase
import Sportsman
import com.google.gson.Gson
import io.github.serpro69.kfaker.Faker
import java.io.FileReader

class SportsmanGenerator {
    fun generateSportsman() : Sportsman {
        val faker = Faker()
        val gson = Gson()
        val namesDatabase: NamesDatabase = gson.fromJson(FileReader(NAMES_DATABASE_PATH), NamesDatabase::class.java)
        val sportsDatabase: SportsDatabase = gson.fromJson(FileReader(SPORTS_DATABASE_PATH), SportsDatabase::class.java)

        lateinit var firstName: String
        lateinit var middleName: String
        lateinit var lastName: String

        if (faker.gender.binaryTypes()=="Male") {
            firstName = namesDatabase.maleFirstNames.random()
            middleName = namesDatabase.maleMiddleNames.random()
            lastName = namesDatabase.maleLastNames.random()
        } else {
            firstName = namesDatabase.femaleFirstNames.random()
            middleName = namesDatabase.femaleMiddleNames.random()
            lastName = namesDatabase.femaleLastNames.random()
        }

        return Sportsman(
            fullName = "$lastName $firstName $middleName",
            age = (15u..50u).random(),
            height = (150u..210u).random(),
            weight = (40u..100u).random(),
            sportsType = sportsDatabase.summerOlympics.random()
        )
    }

    private companion object {
        const val DATA_BASES_PATH = "src/main/resources/Databases"
        const val NAMES_DATABASE_PATH = "$DATA_BASES_PATH/NamesDatabase.json"
        const val SPORTS_DATABASE_PATH = "$DATA_BASES_PATH/SportsDatabase.json"
    }
}