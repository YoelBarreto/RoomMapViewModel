package data

import androidx.room.*

@Dao
interface MarkDao {
    @Insert
    suspend fun insert(task: Task)
    @Query("SELECT * FROM tasks")
    suspend fun getAllMarks(): List<Task>
    @Update suspend fun update(task: Task)
    @Delete suspend fun delete(task: Task)
}
