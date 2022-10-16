package com.vanik.roomproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.vanik.roomproject.db.AppDatabase
import com.vanik.roomproject.entity.Car

class MainActivity : AppCompatActivity() {

    private lateinit var insertButton: Button
    private lateinit var deleteButton: Button
    private lateinit var updateButton: Button
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButtons()
        insertButton.setOnClickListener { insertData() }
        deleteButton.setOnClickListener { deleteData(editText.text.toString()) }
        updateButton.setOnClickListener { updateData(editText.text.toString()) }
    }

    private fun setButtons() {
        insertButton = findViewById(R.id.buttonInsert)
        deleteButton = findViewById(R.id.buttonDelete)
        updateButton = findViewById(R.id.buttonUpdate)
        editText = findViewById(R.id.editText)
    }

    private fun insertData() {
        for (i in 1..10) {
            val serialNumber: Long = (i * 10000000).toLong()
            val car = Car(serialNumber, "mercedes", 200)
            AppDatabase.getInstance(this).CarDao().insert(car)
        }
    }

    private fun deleteData(serialNumberEditText: String) {
        if(serialNumberEditText.isNotEmpty()) {
            val serialNumber: Long = (serialNumberEditText.toInt() * 10000000).toLong()
            val car = Car(serialNumber, "mercedes", 200)
            AppDatabase.getInstance(this).CarDao().delete(car)
        }
    }

    private fun updateData(serialNumberEditText: String) {
        if(serialNumberEditText.isNotEmpty()) {
            val serialNumber: Long = (serialNumberEditText.toInt() * 10000000).toLong()
            val car = Car(serialNumber, "mercedes", 300)
            AppDatabase.getInstance(this).CarDao().update(car)
        }
    }


}