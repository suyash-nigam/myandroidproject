package com.example.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notesTable")
class Note(@ColumnInfo(name = "description") var noteDescription : String) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}