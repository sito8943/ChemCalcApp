package com.sito.chemcalc.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sito.chemcalc.data.local.dao.ElementDao
import com.sito.chemcalc.data.local.dao.SubstanceDao
import com.sito.chemcalc.data.local.model.Element
import com.sito.chemcalc.data.local.model.Substance


@Database(
    entities = [Element::class, Substance::class],
    version = 1,
    exportSchema = false
)
abstract class ChemCalcDb : RoomDatabase() {

    abstract fun substanceDao(): SubstanceDao
    abstract fun elementDao(): ElementDao

    companion object {
        @Volatile
        private var INSTANCE: ChemCalcDb? = null

        fun getDatabase(context: Context): ChemCalcDb {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): ChemCalcDb {
            return Room.databaseBuilder(context, ChemCalcDb::class.java, "ChemCalc.db")
                .build()
        }

    }

}