package com.example.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesTable")
class Note(@ColumnInfo(name = "description") val noteDescription : String) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}