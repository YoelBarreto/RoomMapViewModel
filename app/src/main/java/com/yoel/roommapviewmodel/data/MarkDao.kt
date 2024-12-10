package com.yoel.roommapviewmodel.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MarkDao {
    @Insert
    suspend fun insertMark(task: Mark)

    @Query("SELECT * FROM marks")
    suspend fun getAllMarksAndTypes(): Flow<List<MarkWithTypeMark>>
}
