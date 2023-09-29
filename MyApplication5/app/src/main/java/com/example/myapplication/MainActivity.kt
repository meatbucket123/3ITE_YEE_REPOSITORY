package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var showAccount = findViewById<Button>(R.id.showAccount)
        var editAccount = findViewById<EditText>(R.id.edtAccount)
        var editPassword = findViewById<EditText>(R.id.edtPassword)
   var addAccount = findViewById<Button>(R.id.addAccount)

        var deleteAccount = findViewById<Button>(R.id.deleteAccount)
        var deleteToastStatement = "Account deleted"
   var addToastStatement = "Account is already existing"
    var updatedToastStatement = "Account is not existing"
        var arrayAccount = ArrayList<String>()
        var arrayPassword = ArrayList<String>()

        addAccount.setOnClickListener{
            try {
                val existingAccount =
                    arrayAccount.stream().anyMatch { x -> x == editAccount.text.toString() }
                Log.i("info_yee", existingAccount.toString())
                if(!existingAccount){
                    arrayAccount.add(editAccount.text.toString())
                    arrayPassword.add(editPassword.text.toString())
                    addToastStatement = "Account added successfully!"
                    Log.i("info_yee", existingAccount.toString())

                    Toast.makeText(this, addToastStatement, Toast.LENGTH_SHORT).show()
                }
                else {
                    addToastStatement = "Account already exists!"
                    Toast.makeText(this, addToastStatement, Toast.LENGTH_SHORT).show()
                }
            } catch (e: java.lang.Exception) {
                Log.e("error_yee", e.message.toString())
            }
        }

        editAccount.setOnClickListener{
            try {
                var existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                var existingPassword = arrayPassword[existingAccount]
                Log.i("info_yee", existingAccount.toString())
                if(existingAccount >= 0 && existingPassword == editPassword.text.toString()){
                    arrayAccount[existingAccount] = arrayAccount[existingAccount] + "_updated"
                    arrayPassword[existingAccount] = arrayPassword[existingAccount] + "_updated"
                    updatedToastStatement = "Account Updated Successfully!"
                    Log.i("info_yee", updatedToastStatement)

                    Toast.makeText(this, updatedToastStatement, Toast.LENGTH_SHORT).show()
                }
                else{
                    updatedToastStatement = "Account doesn't exist or incorrect password!"
                    Toast.makeText(this, updatedToastStatement, Toast.LENGTH_SHORT).show()
                }
            } catch (e: java.lang.Exception) {
                Log.e("error_yee", e.message.toString())
            }
        }
        deleteAccount.setOnClickListener{
            try {
                var existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                var existingPassword = arrayPassword[existingAccount]
                Log.i("info_yee", existingAccount.toString())
                if(existingAccount >= 0 && existingPassword == editPassword.text.toString()){
                    arrayAccount.removeAt(existingAccount)
                    arrayPassword.removeAt(arrayPassword.indexOf((editPassword.text.toString())))
                    deleteToastStatement = "Account Deleted Successfully!"
                    Log.i("info_yee", deleteToastStatement)

                    Toast.makeText(this, deleteToastStatement, Toast.LENGTH_SHORT).show()
                }
                else{
                    deleteToastStatement = "Account doesn't exist or incorrect password !"
                    Toast.makeText(this, deleteToastStatement, Toast.LENGTH_SHORT).show()
                }
            } catch (e: java.lang.Exception) {
                Log.e("error_yee", e.message.toString())
            }
        }
        showAccount.setOnClickListener {
            try {
                var existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                Log.i("info_yee", existingAccount.toString())
                if(arrayAccount.size > 0){
                    var arraySize = arrayAccount.size - 1
                    var x = 0
                    while(x <= arraySize){
                        Toast.makeText(this, arrayAccount[x], Toast.LENGTH_SHORT).show()
                        x++
                    }
                }
                else{
                    deleteToastStatement = "No accounts exist!!"
                    Toast.makeText(this, deleteToastStatement, Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("error_yee", e.message.toString())
            }
        }
    }

}