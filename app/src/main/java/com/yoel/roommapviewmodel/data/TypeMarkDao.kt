package com.yoel.roommapviewmodel.data

import androidx.room.*

@Dao
interface TypeMarkDao {
    @Insert
    suspend fun insertTypeMark(typeMark: TypeMark)

    @Query("SELECT * FROM type_marks")
    suspend fun getAllTypeMarks(): List<TypeMark>

    @Query("SELECT name FROM type_marks WHERE id = :id")
    suspend fun getTitleById(id: Int): String?
}