package com.example.ics26011_activity_100323_oop

import android.view.ViewGroup
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentContainer
class FragmentClass : DialogFragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View?{
        var rootView: View = inflater.inflate(R.layout.activity_fragment, container, false)
var bundle_argument = arguments
        var firstNewVariable = bundle_argument?.getString("bundle01")
        var secondNewVariable = bundle_argument?.getString("bundle02")
        var textFirstValue : TextView = rootView.findViewById(R.id.txtFirstVal)
        var textSecondValue : TextView = rootView.findViewById(R.id.txtSecondVal)

        var buttonDismiss : Button = rootView.findViewById(R.id.button)

        textFirstValue.setText(firstNewVariable.toString())
        textSecondValue.setText(secondNewVariable.toString())

        buttonDismiss.setOnClickListener{
            dismiss()
        }

        var buttonRegister : Button = rootView.findViewById(R.id.btnRegister)

        buttonRegister.setOnClickListener {


        }
        return rootView
    }
}