package com.example.todo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1)
abstract class NotesDatabase : RoomDatabase(){
    abstract fun getNotesDao() : NoteDao

    companion object{
        private lateinit var databaseInsatance : NotesDatabase
        fun getDatabase(context : Context) : NotesDatabase{
            val instance = Room.databaseBuilder(
                context.applicationContext, NotesDatabase::class.java, "note_db")
                .build()
            return instance
        }
    }
}