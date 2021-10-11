package com.sito.chemcalc.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "substance")
data class Substance(
    val Name: String,
    val Formula: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}