package databasesMappers

/**
 * A json database is mapped to an object of this class
 * @author Pavel Zilbershteyn
 * @constructor databases as List of String
 * with male and female firstnames, middlenames and lastnames
 */
data class NamesDatabase(
    val maleFirstNames: List<String>,
    val maleMiddleNames: List<String>,
    val maleLastNames: List<String>,
    val femaleMiddleNames: List<String>,
    val femaleFirstNames: List<String>,
    val femaleLastNames: List<String>,
)