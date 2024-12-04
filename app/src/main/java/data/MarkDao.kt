package data

import androidx.room.*

@Dao
interface MarkDao {
    @Insert
    suspend fun insert(task: Mark)
    @Query("SELECT * FROM marks")
    suspend fun getAllMarks(): List<Mark>
    @Update suspend fun update(task: Mark)
    @Delete suspend fun delete(task: Mark)
}
