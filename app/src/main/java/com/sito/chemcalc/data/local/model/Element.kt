package com.sito.chemcalc.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "element")
data class Element(
    val Name: String,
    val Symbol: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}