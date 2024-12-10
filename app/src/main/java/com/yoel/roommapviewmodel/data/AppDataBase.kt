package com.yoel.roommapviewmodel.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@Database(entities = [Mark::class, TypeMark::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun markDao(): MarkDao
    abstract fun typeMarkDao(): TypeMarkDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "map_database"
                ).build()
                INSTANCE = instance

//                GlobalScope.launch {
//                    firstData(instance.typeMarkDao(), instance.markDao())
//                }
                instance
            }
        }
        private suspend fun firstData(typeMarkDao: TypeMarkDao, markDao: MarkDao) {
            val types = listOf(
                TypeMark(name = "Comercio"),
                TypeMark(name = "Cultural"),
                TypeMark(name = "Hospedaje"),
                TypeMark(name = "Playas")
            )

            val typesInserted = typeMarkDao.getAllTypeMarks().first()

            if (typesInserted.isEmpty()) {
                types.forEach {
                    typeMarkDao.insertTypeMark(it)
                }
            }

            val typesInsertedUpd = typeMarkDao.getAllTypeMarks().first()

            val marks = listOf(
                // -------Comercio
                // 1 28.956845569943642, -13.586779205792755
                Mark(name = "Centro Comercial Deiland", x = 28.956845569943642, y = -13.586779205792755, typeMarkId = typesInsertedUpd[0].id),
                // 2 28.95806336981142, -13.585313992621943
                Mark(name = "Milar Lanzarote", x = 28.95806336981142, y = -13.585313992621943, typeMarkId = typesInsertedUpd[0].id),
                // 3 28.959074717504215, -13.591601638386324
                Mark(name = "Lidl", x = 28.959074717504215, y = -13.591601638386324, typeMarkId = typesInsertedUpd[0].id),
                // 4 28.95951322590405, -13.592477431479727
                Mark(name = "Mercadona Playa Honda", x = 28.95951322590405, y = -13.592477431479727, typeMarkId = typesInsertedUpd[0].id),
                // 5 28.957169170585573, -13.599439057067102
                Mark(name = "Hiperdino San Bartolome", x = 28.957169170585573, y = -13.599439057067102, typeMarkId = typesInsertedUpd[0].id),
                // -------Cultural
                // 6 28.954667969496054, -13.585789576718417
                Mark(name = "Parque infantíl Los Roques", x = 28.954667969496054, y = -13.585789576718417, typeMarkId = typesInsertedUpd[1].id),
                // 7 29.141827384708, -13.503701097981299
                Mark(name = "Casa/Museo Cesar Manrique", x = 29.141827384708, y = -13.503701097981299, typeMarkId = typesInsertedUpd[1].id),
                // 8 29.18467900560408, -13.50116937418045
                Mark(name = "Mirador de Guinate", x = 29.18467900560408, y = -13.50116937418045, typeMarkId = typesInsertedUpd[1].id),
                // -------Hospedaje
                // 9 28.933295803627374, -13.617606918240945
                Mark(name = "Hotel Beatriz", x = 28.933295803627374, y = -13.617606918240945, typeMarkId = typesInsertedUpd[2].id),
                // 10 28.957249430684957, -13.554364903583792
                Mark(name = "Arrecife Gran Hotel", x = 28.957249430684957, y = -13.554364903583792, typeMarkId = typesInsertedUpd[2].id),
                // -------Playas
                // 11 28.957648137171667, -13.560246906266194
                Mark(name = "Playa del Reducto", x = 28.957648137171667, y = -13.560246906266194, typeMarkId = typesInsertedUpd[3].id),
                // 12 28.95366434029967, -13.582300270827474
                Mark(name = "Playa de la concha", x = 28.95366434029967, y = -13.582300270827474, typeMarkId = typesInsertedUpd[3].id),
            )

            val marksInserted = markDao.getAllMarksAndTypes().first()

            if (marksInserted.isEmpty()) {
                marks.forEach {
                    markDao.insertMark(it)
                }
            }


        }
    }
}