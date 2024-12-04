package com.yoel.roommapviewmodel.data

import androidx.room.Embedded
import androidx.room.Relation

data class MarkWithTypeMark(
    @Embedded val task: Mark,
    @Relation(
        parentColumn = "typeMarkId",
        entityColumn = "id"
    )
    val typeTask: TypeMark
)