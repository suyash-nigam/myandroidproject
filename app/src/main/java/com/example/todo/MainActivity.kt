package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), onDeleteClick, onNoteClick {

    lateinit var noteViewModel: NoteViewModel
    private var noteNow : Note = Note("")
    lateinit var myAdapter: MyAdapter

    private lateinit var addButton : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

        val myRecyclerView = findViewById<RecyclerView>(R.id.recyView)
        myAdapter = MyAdapter(this, this, this)
        myRecyclerView.adapter = myAdapter
        myRecyclerView.layoutManager = LinearLayoutManager(this)

        noteViewModel.allNote.observe(this, Observer {
            it?.let {
                updateList(it)
            }
        })

        addButton = findViewById<FloatingActionButton>(R.id.addFab)
        addButton.setOnClickListener(){
            val editActivity = Intent(this, EditActivity::class.java)
            startActivityForResult(editActivity, 2)
        }


    }

    private fun updateList(list : List<Note>) {
        myAdapter.updateList(list)
    }
    override fun onDeleteC(note: Note) {
        noteViewModel.deleteNote(note)
    }

    override fun onNoteC(note: Note) {
        noteNow = note
        var editableText = findViewById<EditText>(R.id.editTextBox)
        addButton = findViewById(R.id.addFab)
        editableText.setText(note.noteDescription)
        Log.d("this", "notec")

        val editActivity = Intent(this, EditActivity::class.java)
        editActivity.putExtra("note", note)
        startActivityForResult(editActivity, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(data!=null){
                var note = data?.getSerializableExtra("note") as Note
                Log.d("this", "result here ${note.noteDescription} ${note.id}")
                noteViewModel.updateNote(note)
            }

        }
        if (requestCode==2){
            var note : Note
            if (data != null) {
                note = data?.getSerializableExtra("note") as Note
                noteViewModel.insertNote(note)
            }
        }
    }

    fun createNt(view: View) {
        var editableText = findViewById<EditText>(R.id.editTextBox)
        var text = editableText.text.toString()
        editableText.onEditorAction(EditorInfo.IME_ACTION_DONE)
        if(text.isNotEmpty()){
            if(noteNow.noteDescription!=""){
                noteNow.noteDescription = text
                noteViewModel.updateNote(noteNow)
            }
            else noteViewModel.insertNote(Note(text))
            editableText.setText("")
        }
        else{
            Toast.makeText(this, "Please add your thoughts!", Toast.LENGTH_LONG).show()
        }
    }
}