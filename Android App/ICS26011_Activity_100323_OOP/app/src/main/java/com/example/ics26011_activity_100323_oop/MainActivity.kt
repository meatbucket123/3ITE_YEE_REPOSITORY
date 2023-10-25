package com.example.ics26011_activity_100323_oop

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declaration of object
        var registerObject = RegisterClass()

        //Declaration of Buttons
        var btnRegister : Button = findViewById(R.id.btnPreRegister)
        var btnMainMenu : Button = findViewById(R.id.btnMainMenu)
        //Declaration of EditText
        var edtFirstName : EditText = findViewById(R.id.edtFirstName)
        var edtLastName : EditText = findViewById(R.id.edtLastName)
        var edtUsername : EditText = findViewById(R.id.edtUsername)
        var edtPassword : EditText = findViewById(R.id.edtPassword)
        var edtEmail : EditText = findViewById(R.id.edtEmail)
        var edtMobile : EditText = findViewById(R.id.edtMobileNumber)
        var edtBirthday : EditText = findViewById(R.id.edtBirthday)
        //Declaration of Spinner
        var spinnerAccess : Spinner = findViewById(R.id.spnAccess)
        //Declaration of TextViews
        var txtUsernameErr : TextView = findViewById(R.id.txtUsernameErr)
        var txtPasswordErr : TextView = findViewById(R.id.txtPasswordErr)
        var txtFirstNameErr : TextView = findViewById(R.id.txtFirstNameErr)
        var txtLastNameErr : TextView = findViewById(R.id.txtLastNameErr)
        var txtEmailErr : TextView = findViewById(R.id.txtEmailErr)
        var txtMobileErr : TextView = findViewById(R.id.txtMobileNumberErr)
        var txtBirthdayErr : TextView = findViewById(R.id.txtBitrthdayErr)
       var stringFirstname = edtFirstName.text.toString()


        //Setting of onclick listeners
        edtBirthday.setOnClickListener {
            val calendar : Calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this, {
                    it, year, month, day ->
                    val dat = (day.toString() + '/' + (month+1) + '/' + year)
                    edtBirthday.setText(dat)
                }, year, month, day
            )
            datePickerDialog.show()
        }
        edtMobile.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){
                try {
                    if(edtMobile.text.length >= 12) {
                        txtMobileErr.text = "Mobile number must be 11 digits."
                        edtMobile.setText(edtMobile.text.substring(0,edtMobile.length()-1))
                        edtMobile.setSelection(11)

                    }
                } catch (e : Exception) {
                    Log.e("error_mobile", e.message.toString())
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        btnRegister.setOnClickListener {
            var registerObject = RegisterClass()

            //Declaration of Buttons
            var btnRegister : Button = findViewById(R.id.btnPreRegister)
            var btnMainMenu : Button = findViewById(R.id.btnMainMenu)
            //Declaration of EditText
            var edtFirstName : EditText = findViewById(R.id.edtFirstName)
            var edtLastName : EditText = findViewById(R.id.edtLastName)
            var edtUsername : EditText = findViewById(R.id.edtUsername)
            var edtPassword : EditText = findViewById(R.id.edtPassword)
            var edtEmail : EditText = findViewById(R.id.edtEmail)
            var edtMobile : EditText = findViewById(R.id.edtMobileNumber)
            var edtBirthday : EditText = findViewById(R.id.edtBirthday)
            //Declaration of Spinner
            var spinnerAccess : Spinner = findViewById(R.id.spnAccess)
            //Declaration of TextViews
            var txtUsernameErr : TextView = findViewById(R.id.txtUsernameErr)
            var txtPasswordErr : TextView = findViewById(R.id.txtPasswordErr)
            var txtFirstNameErr : TextView = findViewById(R.id.txtFirstNameErr)
            var txtLastNameErr : TextView = findViewById(R.id.txtLastNameErr)
            var txtEmailErr : TextView = findViewById(R.id.txtEmailErr)
            var txtMobileErr : TextView = findViewById(R.id.txtMobileNumberErr)
            var txtBirthdayErr : TextView = findViewById(R.id.txtBitrthdayErr)

            //Setting of onclick listeners
            edtBirthday.setOnClickListener {
                val calendar : Calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                val datePickerDialog = DatePickerDialog(
                    this, {
                            it, year, month, day ->
                        val dat = (day.toString() + '/' + (month+1) + '/' + year)
                        edtBirthday.setText(dat)
                    }, year, month, day
                )
                datePickerDialog.show()
            }
            edtMobile.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){
                    try {
                        if(edtMobile.text.length >= 12) {
                            txtMobileErr.text = "Mobile number must be 11 digits."
                            edtMobile.setText(edtMobile.text.substring(0,edtMobile.length()-1))
                            edtMobile.setSelection(11)

                        }
                    } catch (e : Exception) {
                        Log.e("error_mobile", e.message.toString())
                    }
                }

                override fun afterTextChanged(p0: Editable?) {}
            })


            var fragmentObject = FragmentClass()
            var bundle = Bundle()


            bundle.putString("bundle01", stringFirstname)
            bundle.putString("bundle02", "Yee")
            fragmentObject.arguments = bundle
            fragmentObject.show(supportFragmentManager, "Custom")

        }

        btnMainMenu.setOnClickListener {

        }

        //Populating the spinner
        val accesses = resources.getStringArray(R.array.Accesses)
        val adapter = ArrayAdapter(this, R.layout.activity_spinner, R.id.txtSpinner, accesses)
        spinnerAccess.adapter = adapter
    }
}