package com.example.basiccalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {

    var lastNumeric: Boolean = false
    var lastDot: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View) {
        tvInput.append((view as Button).text)
        lastNumeric= true
    }

    fun onClear(view: View) {
        tvInput.text = ""
        lastNumeric= false
        lastDot= false
    }

    fun onDecimalPoint(view: View){
        if(lastNumeric && !lastDot){
            tvInput.append(".")
            lastNumeric= false
            lastDot= true
        }
    }

    fun onOperator(view: View){
        if(lastNumeric && !isOperatorAdded(tvInput.text.toString())){
            tvInput.append((view as Button).text)
            lastNumeric= false
            lastDot= false
        }
    }

    fun onEqual(view: View){
        if(lastNumeric){
            var tvValue= tvInput.text.toString()
            var prefix=""
            try{

                if(tvValue.startsWith("-")){
                    prefix="-"
                    tvValue=tvValue.substring(1)
                }

                if(tvValue.contains("-")){
                    val splitValue=tvValue.split("-")

                    var one = splitValue[0].toDouble()
                    var two = splitValue[1].toDouble()
                    if(prefix.isNotEmpty()){
                        one *= -1
                    }
                    tvInput.text= (one - two).toString()
                }
                else if(tvValue.contains("+")){
                    val splitValue=tvValue.split("+")
                    var one = splitValue[0].toDouble()
                    var two = splitValue[1].toDouble()
                    if(prefix.isNotEmpty()){
                        one *= -1
                    }
                    tvInput.text= (one + two).toString()
                }
                else if(tvValue.contains("*")){
                    val splitValue=tvValue.split("*")
                    var one = splitValue[0].toDouble()
                    var two = splitValue[1].toDouble()
                    if(prefix.isNotEmpty()){
                        one *= -1
                    }
                    tvInput.text= (one * two).toString()
                }

                else if(tvValue.contains("/")){
                    val splitValue=tvValue.split("/")
                    var one = splitValue[0].toDouble()
                    var two = splitValue[1].toDouble()
                    if(prefix.isNotEmpty()){
                        one *= -1
                    }
                    if(two != 0.0) {
                        tvInput.text = (one / two).toString()
                    }
                    else{
                        tvInput.text = "ERROR"
                    }
                }
            }catch(e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    private fun isOperatorAdded(value: String): Boolean{
        return if (value.startsWith("-")){
            false
        }
        else{
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
        }
    }

}
