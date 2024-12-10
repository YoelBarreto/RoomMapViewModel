package com.yoel.roommapviewmodel.data

import androidx.room.*

@Dao
interface MarkDao {
    @Insert
    suspend fun insertMark(task: Mark)

    @Query("SELECT * FROM marks")
    suspend fun getAllMarks(): List<Mark>
}
