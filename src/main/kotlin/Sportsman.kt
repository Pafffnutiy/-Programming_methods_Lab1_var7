/**
 * Sportsman class
 * @author Pavel Zilbershteyn
 * @constructor Create object by
 * fullName, age, height, weight and sportsType
 */
data class Sportsman(
    val fullName: String,
    val age: UInt,
    val height: UInt,
    val weight: UInt,
    val sportsType: String
) : Comparable<Sportsman> {
    /**
     * Overrided fun of equals (a==b) between two Sportsman objects
     * If b isn't Sportsman - false
     * @param other Any object
     * @return true if a and b equals by fields
     * sportsType, fullName and age and false otherwise
     */
    override fun equals(other: Any?): Boolean {
        if (other !is Sportsman) return false
        return  this.sportsType == other.sportsType &&
                this.fullName == other.fullName     &&
                this.age == other.age
    }

    /**
     * Overrided compares (>, <, >=, <=) of two Sportsman objects
     * @param other Sportsman object
     * @return difference as Int
     */
    override fun compareTo(other: Sportsman): Int {
        return  compareValuesBy(
            this,
            other,
            Sportsman::sportsType,
            Sportsman::fullName,
            Sportsman::age
        )
    }

    /**
     * Overrided hashCode fun
     * @param Empty
     * @return hashCode as Int
     */
    override fun hashCode(): Int {
        return listOf(sportsType, fullName, age).hashCode() * 31
    }
}
