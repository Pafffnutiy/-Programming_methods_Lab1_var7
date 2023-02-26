package databasesMappers

/**
 * A json database is mapped to an object of this class
 * @author Pavel Zilbershteyn
 * @constructor database as List of String
 * with types of sports
 */
data class SportsDatabase(
    val summerOlympics: List<String>
)