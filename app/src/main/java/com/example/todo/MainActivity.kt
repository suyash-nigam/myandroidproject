package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list : ArrayList<String> = ArrayList<String>()

        list = createList()

        Log.d("size", list.toString())

        val myRecyclerView = findViewById<RecyclerView>(R.id.recyView)
        val myAdapter = MyAdapter(list)
        myRecyclerView.adapter = myAdapter
        myRecyclerView.layoutManager = LinearLayoutManager(this)


    }

    private fun createList(): ArrayList<String> {

        var list : ArrayList<String> = ArrayList<String>()

        list.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce non lacinia massa, sit amet tincidunt dui. Donec ultricies consectetur egestas.")
        list.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce non lacinia massa, sit amet tincidunt dui. Donec ultricies consectetur egestas.")
        list.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce non lacinia massa, sit amet tincidunt dui. Donec ultricies consectetur egestas.")
        list.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce non lacinia massa, sit amet tincidunt dui. Donec ultricies consectetur egestas.")
        list.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce non lacinia massa, sit amet tincidunt dui. Donec ultricies consectetur egestas.")
        list.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce non lacinia massa, sit amet tincidunt dui. Donec ultricies consectetur egestas.")
        list.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce non lacinia massa, sit amet tincidunt dui. Donec ultricies consectetur egestas.")
        list.add("Suyash is my name Suyash is my nameSuyash is my nameSuyash is my nameSuyash is my name")
        list.add("Suyash is my name Suyash is my nameSuyash is my nameSuyash is my nameSuyash is my name")
        list.add("Suyash is my name Suyash is my nameSuyash is my nameSuyash is my nameSuyash is my name")
        list.add("Suyash is my name Suyash is my nameSuyash is my nameSuyash is my nameSuyash is my name")
        list.add("Suyash is my name Suyash is my nameSuyash is my nameSuyash is my nameSuyash is my name")
        list.add("Suyash is my name Suyash is my nameSuyash is my nameSuyash is my nameSuyash is my name")
        list.add("Rajat")
        list.add("Abhishek")
        list.add("Vaibhav")
        list.add("Amit")
        return list
    }
}