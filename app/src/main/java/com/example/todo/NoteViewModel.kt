package com.example.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val allNote : LiveData<List<Note>>
    val repository : NoteRepository

    init {
        val dao = NotesDatabase.getDatabase(application).getNotesDao()
        repository = NoteRepository(dao)
        allNote = repository.allNotes
    }
}