package com.yoel.roommapviewmodel.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TypeMarkDao {
    @Insert
    suspend fun insertTypeMark(typeMark: TypeMark)

    @Query("SELECT * FROM type_marks")
    fun getAllTypeMarks(): Flow<List<TypeMark>>
}