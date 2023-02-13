package com.example.todo

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.currentCoroutineContext
import org.w3c.dom.Text

class MyAdapter(private var context : Context, var onNoteClick: onNoteClick, var onDeleteClick: onDeleteClick) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    private val allNotes = ArrayList<Note>()
    inner class MyHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textData : TextView = itemView.findViewById(R.id.textListView)
        val del : TextView = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val noteView = inflater.inflate(R.layout.activity_custom_list_view, parent, false)
        val holder = MyHolder(noteView)
        holder.del.setOnClickListener(){
            Log.d("this", "Delete")
            onDeleteClick.onDeleteC(allNotes.get(holder.absoluteAdapterPosition))
        }
        holder.textData.setOnClickListener(){
            onNoteClick.onNoteC(allNotes.get((holder.absoluteAdapterPosition)))
        }
        return holder
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val note = allNotes.get(position)
        val text = holder.textData
        text.setText(note.noteDescription.toString())
        holder.del.setText(buildString { append("Delete") })

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList : List<Note>){
        allNotes.clear();
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}

interface onDeleteClick{
    fun onDeleteC(note : Note)
}

interface onNoteClick{

    fun onNoteC(note : Note)
}