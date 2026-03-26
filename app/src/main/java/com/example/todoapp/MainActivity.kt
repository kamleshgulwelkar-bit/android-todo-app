package com.example.todoapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var addButton: Button
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private val tasks = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextTask)
        addButton = findViewById(R.id.buttonAdd)
        listView = findViewById(R.id.listViewTasks)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        listView.adapter = adapter

        addButton.setOnClickListener {
            val task = editText.text.toString()
            if (task.isNotEmpty()) {
                tasks.add(task)
                adapter.notifyDataSetChanged()
                editText.text.clear()
            } else {
                Toast.makeText(this, "Enter a task", Toast.LENGTH_SHORT).show()
            }
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            tasks.removeAt(position)
            adapter.notifyDataSetChanged()
            true
        }
    }
}