package databasesMappers

data class NamesDatabase(
    val maleFirstNames: List<String>,
    val maleMiddleNames: List<String>,
    val maleLastNames: List<String>,
    val femaleMiddleNames: List<String>,
    val femaleFirstNames: List<String>,
    val femaleLastNames: List<String>,
)