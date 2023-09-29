package com.example.freetest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var letters = "";
    var numbers = 0;
    var op =0;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button);
        val btn2 = findViewById<Button>(R.id.button2);
        val btn3 = findViewById<Button>(R.id.button3);
        val btn4 = findViewById<Button>(R.id.button4);
        val btn5 = findViewById<Button>(R.id.button5);
        val btn6 = findViewById<Button>(R.id.button6);
        val btn7 = findViewById<Button>(R.id.button7);
        val btn8 = findViewById<Button>(R.id.button8);
        btn.setOnClickListener()
        {
            opLetters("A");
        }
        btn2.setOnClickListener()
        {
            opLetters("B");
        }
        btn3.setOnClickListener()
        {
            opLetters("C");
        }
        btn4.setOnClickListener()
        {
            opNumbers(1);
        }
        btn5.setOnClickListener()
        {
            opNumbers(2);
        }
        btn6.setOnClickListener()
        {
            opNumbers(3);
        }
        btn7.setOnClickListener(){
            add();
        }
        btn8.setOnClickListener(){
            sub();
        }
    }
    fun opLetters(letter: String)
    {
        if(op == 1) {
            letters += letter;
            op = 0
            Toast.makeText(this, letters, Toast.LENGTH_SHORT).show();
        }
        else if (op == 2) {
           letters = letters.dropLast(1)
            op = 0
            Toast.makeText(this, letters, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "No operatior LMAO", Toast.LENGTH_SHORT).show();
        }

    }

    fun opNumbers(number: Int)
    {
        if(op == 1 ){
            numbers += number;
            op = 0
            Toast.makeText(this, numbers.toString(), Toast.LENGTH_SHORT,).show();
        }
        else if (op == 2) {
            if(numbers > number){
                numbers -= number;
                op = 0
                Toast.makeText(this, numbers.toString(), Toast.LENGTH_SHORT,).show();
            }
            else{
                numbers = 0;
                Toast.makeText(this, "Cannot go below 0", Toast.LENGTH_SHORT,).show();
                op = 0
            }

        }
        else {
            Toast.makeText(this, "No operator chosen", Toast.LENGTH_SHORT,).show();
        }


    }
    fun add(){
        op = 1;
    }
    fun sub(){
        op = 2;
    }
}