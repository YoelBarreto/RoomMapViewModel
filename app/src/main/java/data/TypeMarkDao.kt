package data

import androidx.room.*

@Dao
interface TypeMarkDao {
    @Insert
    suspend fun insertTypeMark(typeMark: TypeMark)

    @Query("SELECT * FROM type_marks")
    suspend fun getAllTypeMarks(): List<TypeMark>

    @Update
    suspend fun updateTypeMark(typeMark: TypeMark)

    @Delete
    suspend fun deleteTypeMark(typeMark: TypeMark)

    @Query("SELECT titulo FROM type_marks WHERE id = :id")
    suspend fun getTitleById(id: Int): String?
}