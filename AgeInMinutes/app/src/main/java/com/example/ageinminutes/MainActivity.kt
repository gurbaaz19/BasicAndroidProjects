package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)
        }
    }

    fun clickDatePicker(view: View) {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->

                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"

                Toast.makeText(this, "The chosen day is $selectedDate", Toast.LENGTH_SHORT).show()

                tvSelectedDate.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateInMinutes =
                    currentDate!!.time / 60000 //.time returns in milliseconds

                val selectedDateInMinutes = theDate!!.time / 60000  //.time returns in milliseconds

                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                tvSelectedDateInMinutes.text = differenceInMinutes.toString()

                val differenceInDays = differenceInMinutes / 1440

                tvSelectedDateInDays.text = differenceInDays.toString()

            }, year, month, day
        )

        dpd.datePicker.maxDate = Date().time - 86400000

        dpd.show()
    }
}