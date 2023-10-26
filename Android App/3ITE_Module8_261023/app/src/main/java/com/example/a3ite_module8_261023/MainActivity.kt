package com.example.a3ite_module8_261023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.lang.Integer.parseInt
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
var buttonRandomizer : Button = findViewById(R.id.btnRandomize)

var newHash : HashMap<String, String> = HashMap<String, String>()
        var anotherHash: Map <String, Int>
        newHash.put("amado","sap")
        newHash.get("amado")
        val randonum = Random


        buttonRandomizer.setOnClickListener {
            var ranging = randonum.nextInt(2)

      if (ranging == 1){
         var ranging = true

          hashData(oneNum, hashWords.get(OneNum).toString(), ranging)


      }else{
          var ranging = false
          hashData(oneNum, hashWords.get(OneNum).toString(), ranging)
      }
            Log.i("info_yee", ranging.toString())
        }





    }
}