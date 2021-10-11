package com.sito.chemcalc.data.local.dao

import androidx.room.*
import com.sito.chemcalc.data.local.model.Substance
import kotlinx.coroutines.flow.Flow

@Dao
interface SubstanceDao {

    @Insert
    suspend fun insert(substance: Substance)

    @Update
    suspend fun update(substance: Substance)

    @Delete
    suspend fun delete(substance: Substance)

    @Query("SELECT * FROM substance WHERE id=:id")
    suspend fun getSubstanceById(id: Int): Substance

    @Query("SELECT * FROM substance WHERE formula=:formula")
    suspend fun getSubstanceByFormula(formula: String): Substance

    @Query("SELECT * FROM substance")
    fun getAllSubstances(): Flow<List<Substance>>

}