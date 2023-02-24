data class Sportsman(
    val fullName: String,
    val age: UInt,
    val height: UInt,
    val weight: UInt,
    val sportsType: String
) : Comparable<Sportsman> {
    override fun equals(other: Any?): Boolean {
        if (other !is Sportsman) return false
        return  this.sportsType == other.sportsType &&
                this.fullName == other.fullName     &&
                this.age == other.age
    }

    override fun compareTo(other: Sportsman): Int {
        return  compareValuesBy(
            this,
            other,
            Sportsman::sportsType,
            Sportsman::fullName,
            Sportsman::age
        )
    }

    override fun hashCode(): Int {
        return listOf(sportsType, fullName, age).hashCode() * 31
    }
}
