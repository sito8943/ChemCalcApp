package com.sito.chemcalc.data.local.dao

import androidx.room.*
import com.sito.chemcalc.data.local.model.Element
import kotlinx.coroutines.flow.Flow

@Dao
interface ElementDao {

    @Insert
    suspend fun insert(element: Element)

    @Update
    suspend fun update(element: Element)

    @Delete
    suspend fun delete(element: Element)

    @Query("SELECT * FROM element WHERE id=:id")
    suspend fun getElementById(id: Int): Element

    @Query("SELECT * FROM element WHERE symbol=:symbol")
    suspend fun getElementBySymbol(symbol: String): Element

    @Query("SELECT * FROM element")
    fun getAllElements(): Flow<List<Element>>

}