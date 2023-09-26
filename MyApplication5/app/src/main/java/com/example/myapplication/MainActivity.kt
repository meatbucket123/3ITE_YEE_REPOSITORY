package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var showAccount = findViewById<Button>(R.id.showAccount)
   var textAccount = findViewById<TextView>(R.id.textView)
   var addAccount = findViewById<Button>(R.id.addAccount)
        var editAccount = findViewById<Button>(R.id.editAccount)
        var deleteAccount = findViewById<Button>(R.id.deleteAccount)
   var addToastStatement = "Account is already existing"
    var updatedToastStatement = "Account is not existing"
        var arrayAccount = ArrayList<String>()
        var arrayPassword = ArrayList<String>()

        addAccount.setOnClickListener{
        try{
            val existingAccount = arrayAccount.stream().anyMatch{x -> x == editAccount.text.toString()}
                        val existingPassword = arrayPassword.stream().anyMatch{x -> x == editAccount.text.toString()}
            Log.i("info.yee", existingAccount.toString())
            Log.i("info.yee",  existingPassword.toString())
        }catch(e: Exception){
            Log.e("error.yee", e.message.toString() )
        }
        }

        editAccount.setOnClickListener{
            try{
                val existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                val existingPassword = arrayPassword.indexOf(editAccount.text.toString())
                Log.i("info.yee", existingAccount.toString())
                Log.i("info.yee", existingPassword.toString())
                if(existingAccount >= 0 && existingPassword >=0){
                    arrayPassword[existingPassword] = arrayPassword [existingPassword] + "_updated"
                    arrayAccount[existingAccount] = arrayAccount[existingAccount] + "_updated"
                    updatedToastStatement = "Account Updated Succesfully"
                    Log.i("info.yee", updatedToastStatement)
                }  else{
                   updatedToastStatement = "Can't Update Account"
                }
                Toast.makeText(this, updatedToastStatement, Toast.LENGTH_SHORT).show()
            }catch(e:Exception){
                Log.e("error.yee", e.message.toString())
            }
        }
        deleteAccount.setOnClickListener{
            try {
                var existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                Log.i("yee.info", existingAccount.toString())
                if (existingAccount >= 0) {
                    arrayAccount.removeAt(existingAccount)
                    textAccount.setText(arrayAccount.size.toString())
                    editAccount.setText(" ")
                    updatedToastStatement = "Account Succesfully Deleted"

                    Log.i("yee.info", updatedToastStatement)
                }
                Toast.makeText(this, updatedToastStatement, Toast.LENGTH_SHORT)
                updatedToastStatement = "Account is not existing"

            }
            catch (e: Exception){
                Log.e("error.yee", e.message.toString())
            }
        }
        showAccount.setOnClickListener {
            try{
                  var existingAccount = arrayAccount.indexOf(editAccount.text.toString())
                Log.i("info.yee", existingAccount.toString())
                if(arrayAccount.size > 0){
                    var arraySize = arrayAccount.size - 1
                    /*for(x in 0 .. arraySize)
                        Toast.makeText(this, arrayAccount[x], Toast.LENGTH_SHORT).show() */
                }        else {
                    updatedToastStatement = "No accounts"
                    Toast.makeText(this,updatedToastStatement,Toast.LENGTH_SHORT).show()
                }
            }   catch (e: Exception){
                Log.e("error.yee", e.message.toString())
            }
        }
    }

}