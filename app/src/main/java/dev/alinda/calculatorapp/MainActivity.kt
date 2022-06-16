package dev.alinda.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text


    class MainActivity : AppCompatActivity() {
        lateinit var tilNumber1:TextInputLayout
        lateinit var tilNumber2:TextInputLayout
        lateinit var etNumber1:TextInputEditText
        lateinit var etNumber2:TextInputEditText
        lateinit var btnSubtract:Button
        lateinit var btnAdd:Button
        lateinit var btnDivision:Button
        lateinit var btnModulus:Button
        lateinit var tvResult:TextView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            tilNumber1=findViewById(R.id.tilNumber1)
            tilNumber2=findViewById(R.id.tilNumber2)
            etNumber1=findViewById(R.id.etNumber1)
            etNumber2=findViewById(R.id.etNumber2)
            btnSubtract=findViewById(R.id.btnSubtract)
            btnAdd=findViewById(R.id.btnAdd)
            btnDivision=findViewById(R.id.btnDivision)
            btnModulus=findViewById(R.id.btnModulus)
            tvResult=findViewById(R.id.tvResult)

            btnAdd.setOnClickListener{
                val input=obtainInput()
                addition(input!!.number1,input!!.number2)
            }
            btnSubtract.setOnClickListener{
                val input=obtainInput()
                subtraction(input!!.number1,input!!.number2)
            }
            btnDivision.setOnClickListener{
                val input=obtainInput()
                division(input!!.number1,input!!.number2)
            }
            btnModulus.setOnClickListener{
                val input=obtainInput()
                modulus(input!!.number1,input!!.number2)
            }
        }
        data class Input(var number1:Int,var number2:Int)
        fun obtainInput():Input?{
            val number1=etNumber1.text.toString()
            val number2=etNumber2.text.toString()

            if (number1.isBlank()){
                tilNumber1.error="Number is required"
                return null
            }
            if (number2.isBlank()){
                tilNumber2.error="Number is required"
                return null

            }
            return Input(number1.toInt(),number2.toInt())
        }
        fun addition(number1:Int,number2:Int){
            val add = number1 + number2
            tvResult.text = add.toString()
        }

        fun subtraction(number1:Int,number2:Int){
            val subtract=number1 - number2
            tvResult.text = subtract.toString()
        }

        fun division(number1:Int,number2:Int){
            val divide = number1 / number2
            tvResult.text = divide.toString()
        }

        fun modulus(number1:Int,number2:Int){
            val remainder = number1 % number2
            tvResult.text = remainder.toString()
        }
    }