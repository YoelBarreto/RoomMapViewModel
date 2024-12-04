package data

import androidx.room.Entity import androidx.room.PrimaryKey

@Entity(tableName = "marks")
data class Mark( @PrimaryKey(autoGenerate = true)
                 val id: Int = 0,
                 val name: String,
)
