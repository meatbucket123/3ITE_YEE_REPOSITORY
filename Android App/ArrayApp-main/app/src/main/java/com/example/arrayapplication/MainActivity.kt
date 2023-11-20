package com.example.arrayapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayAccount = ArrayList<String>()
        var arrayPassword = ArrayList<String>()
        var textAccount = findViewById<TextView>(R.id.txtAccount)
        var buttonAccount = findViewById<Button>(R.id.btnAccount)
        var buttonFind = findViewById<Button>(R.id.btnFind)
        var buttonUpdate = findViewById<Button>(R.id.btnUpdate)
        var buttonDelete = findViewById<Button>(R.id.btnDelete)
        var editAccount = findViewById<EditText>(R.id.edtAccount)
        var editPassword = findViewById<EditText>(R.id.edtPassword)
        var addToastStatement = "Account is already existing"
        var updateToastStatement = "Account is not existing"
        var deleteToastStatement = "Account is not existing"

        buttonAccount.setOnClickListener {
            try {
                val existingAccount =
                    arrayAccount.stream().anyMatch { x -> x == editAccount.text.toString() }
                Log.i("info_yee", existingAccount.toString())
                if(!existingAccount){
                    arrayAccount.add(editAccount.text.toString())
                    arrayPassword.add(editPassword.text.toString())
                    addToastStatement = "Account added successfully!"
                    Log.i("info_yee", existingAccount.toString())
                    textAccount.setText(arrayAccount.size.toString())
                    Toast.makeText(this, addToastStatement, Toast.LENGTH_SHORT).show()
                }
                else {
                    addToastStatement = "Account already exists!"
                    Toast.makeText(this, addToastStatement, Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("error_yee", e.message.toString())
            }
        }
        buttonUpdate.setOnClickListener {
            try {
                var existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                var existingPassword = arrayPassword[existingAccount]
                Log.i("info_yee", existingAccount.toString())
                if(existingAccount >= 0 && existingPassword == editPassword.text.toString()){
                    arrayAccount[existingAccount] = arrayAccount[existingAccount] + "_updated"
                    arrayPassword[existingAccount] = arrayPassword[existingAccount] + "_updated"
                    updateToastStatement = "Account Updated Successfully!"
                    Log.i("info_yee", updateToastStatement)
                    textAccount.setText(arrayAccount.size.toString())
                    Toast.makeText(this, updateToastStatement, Toast.LENGTH_SHORT).show()
                }
                else{
                    updateToastStatement = "Account doesn't exist or incorrect password!"
                    Toast.makeText(this, updateToastStatement, Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("error_yee", e.message.toString())
            }
        }

        buttonDelete.setOnClickListener {
            try {
                var existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                var existingPassword = arrayPassword[existingAccount]
                Log.i("info_yee", existingAccount.toString())
                if(existingAccount >= 0 && existingPassword == editPassword.text.toString()){
                    arrayAccount.removeAt(existingAccount)
                    arrayPassword.removeAt(arrayPassword.indexOf((editPassword.text.toString())))
                    deleteToastStatement = "Account Deleted Successfully!"
                    Log.i("info_yee", deleteToastStatement)
                    textAccount.setText(arrayAccount.size.toString())
                    Toast.makeText(this, deleteToastStatement, Toast.LENGTH_SHORT).show()
                }
                else{
                    deleteToastStatement = "Account doesn't exist or incorrect password !"
                    Toast.makeText(this, deleteToastStatement, Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("error_yee", e.message.toString())
            }
        }

        buttonFind.setOnClickListener {
            try {
                var existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                Log.i("info_yee", existingAccount.toString())
                if(arrayAccount.size > 0){
                    var arraySize = arrayAccount.size - 1
                   /* for(x in 0..arraySize)
                    Toast.makeText(this, arrayAccount[x], Toast.LENGTH_SHORT).show() */
                    var x = 0
                   /* do {
                        Toast.makeText(this, arrayAccount[x], Toast.LENGTH_SHORT).show()
                        x++
                    }
                        while(x <= arraySize) */
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