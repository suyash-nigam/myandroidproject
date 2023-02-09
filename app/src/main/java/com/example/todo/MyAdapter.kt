package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MyAdapter(private var notes : ArrayList<String>) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    inner class MyHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textData : TextView = itemView.findViewById(R.id.textListView)
        val del : TextView = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val noteView = inflater.inflate(R.layout.activity_custom_list_view, parent, false)
        return MyHolder(noteView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val note = notes.get(position)
        val text = holder.textData
        text.setText(note)
        holder.del.setText(buildString { append("Delete") })
    }

    override fun getItemCount(): Int {
        return notes.size
    }

}