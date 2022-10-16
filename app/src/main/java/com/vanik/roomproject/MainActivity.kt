package com.vanik.roomproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.vanik.roomproject.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var insertButton: Button
    private lateinit var deleteButton: Button
    private lateinit var updateButton: Button
    private lateinit var editText: EditText
    private val repository = Repository(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButtons()
        insertButton.setOnClickListener { repository.insertData() }
//        deleteButton.setOnClickListener { deleteData(editText.text.toString()) }
//        updateButton.setOnClickListener { updateData(editText.text.toString()) }
    }

    private fun setButtons() {
        insertButton = findViewById(R.id.buttonInsert)
        deleteButton = findViewById(R.id.buttonDelete)
        updateButton = findViewById(R.id.buttonUpdate)
        editText = findViewById(R.id.editText)
    }




}