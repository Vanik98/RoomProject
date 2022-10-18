package com.vanik.roomproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.vanik.roomproject.data.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var insertButton: Button
    private lateinit var deleteButton: Button
    private lateinit var updateButton: Button
    private lateinit var userIdEditText: EditText
    private lateinit var carIdEditText: EditText
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButtons()
        mainViewModel = MainViewModel(this)
        insertButton.setOnClickListener {
            mainViewModel.insertData()
        }
        deleteButton.setOnClickListener {
            val userID = userIdEditText.text.toString()
            val carID = carIdEditText.text.toString()
            mainViewModel.deleteCar(userID, carID)
        }
        updateButton.setOnClickListener {
            val userID = userIdEditText.text.toString()
            val carID = carIdEditText.text.toString()
            mainViewModel.updateCar(userID, carID)
        }
    }

    private fun setButtons() {
        insertButton = findViewById(R.id.buttonInsert)
        deleteButton = findViewById(R.id.buttonDelete)
        updateButton = findViewById(R.id.buttonUpdate)
        userIdEditText = findViewById(R.id.editTextUserId)
        carIdEditText = findViewById(R.id.editTextCarID)
    }


}