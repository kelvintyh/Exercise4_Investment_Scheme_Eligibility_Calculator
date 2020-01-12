package com.example.android.investmentschemeeligibilitycalculator

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Calender
        var c : Calendar = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_YEAR)
        var age : Int = 0

        editDOB.setOnClickListener{
            var editSaving = findViewById<EditText>(R.id.editCurrentSaving)
            var saving = editSaving.text.toString().toDouble()
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view: DatePicker, mYear: Int, mMonth: Int, mDay: Int ->
                //set to textView
                age =  year - mYear
                println("Age: " +age
                        +"current year : " +year
                        +"picked year  : " +mYear)
               val AIA : Double =  Caculate(saving,age)
                viewAIA.setText("RM" +AIA)
                editDOB.setText("" + mDay + "/" + mMonth.plus(1) + "/" + mYear)
            }, year, month, day)

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
            //show dialog
            datePicker.show()
        }
    }

    private fun Caculate(saving:Double, age:Int) : Double{
        var AIA = 0.00
        if( 16 <= age && age <= 20 && saving > 5000)
            AIA = (saving-5000) * 0.30
        else if( 21 <= age && age <= 25 && saving > 14000)
            AIA = (saving-14000) * 0.30
        else if (26 <= age && age <= 30 && saving > 29000)
            AIA = (saving-29000) * 0.30
        else if ( 31 <= age && age <= 35 && saving > 50000 )
            AIA = (saving-50000) * 0.30
        else if ( 36 <= age && age <= 40 && saving > 78000)
            AIA = (saving-78000) * 0.30
        else if (  41 <= age && age <= 45 && saving > 116000 )
            AIA = (saving-116000) * 0.30
        else if ( 46 <= age && age <= 50 && saving > 165000 )
            AIA = (saving-165000) * 0.30
        else if ( 51 <= age && age <= 55 && saving > 228000 )
            AIA = (saving-228000) * 0.30
        else
            AIA = 0.00
        return AIA
    }

}
