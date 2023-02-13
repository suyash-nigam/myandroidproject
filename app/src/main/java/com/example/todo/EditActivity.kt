package com.example.todo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class EditActivity : AppCompatActivity() {

    lateinit var createNote : EditText
    lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        createNote = findViewById(R.id.createNote)
        addButton = findViewById(R.id.addBtn)

        showKeyboard(createNote)

        if(intent.getSerializableExtra("note")!=null){
            val note : Note = intent.getSerializableExtra("note") as Note
            createNote.setText(note.noteDescription.toString())
            addButton.setText("Update")
            createNote.setSelection(note.noteDescription.length)
            Log.d("here", "update note - ${note.id} ${note.noteDescription}")
            addButton.setOnClickListener(){

                Log.d("this", "about to delete")

                note.noteDescription = createNote.text.toString()
                intent.putExtra("newNote", note)
                setResult(2, intent)
                finish()
            }
        }
        else{
            addButton.setOnClickListener(){

                val note : Note = Note("")
                note.noteDescription = createNote.text.toString()
                intent.putExtra("note", note)
                setResult(2, intent)
                finish()
            }
        }
    }

    fun showKeyboard(view : View){
        if(view.requestFocus()){
            var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

}