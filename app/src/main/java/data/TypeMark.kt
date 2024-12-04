package data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "type_marks")
data class TypeMark(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)