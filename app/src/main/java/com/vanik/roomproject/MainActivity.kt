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
    private lateinit var editTextUserId: EditText
    private lateinit var editTextCarId: EditText
    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButtons()
        repository = Repository(this)
        insertButton.setOnClickListener {
            repository.insertData()
        }
        deleteButton.setOnClickListener {
            val userID = editTextUserId.text.toString()
            val carID = editTextCarId.text.toString()
            repository.deleteCar(userID, carID)
        }
        updateButton.setOnClickListener {
            val userID = editTextUserId.text.toString()
            val carID = editTextCarId.text.toString()
            repository.updateCar(userID, carID)
        }
    }

    private fun setButtons() {
        insertButton = findViewById(R.id.buttonInsert)
        deleteButton = findViewById(R.id.buttonDelete)
        updateButton = findViewById(R.id.buttonUpdate)
        editTextUserId = findViewById(R.id.editTextUserId)
        editTextCarId = findViewById(R.id.editTextCarID)
    }


}