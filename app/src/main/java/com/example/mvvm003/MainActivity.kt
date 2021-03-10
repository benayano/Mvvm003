package com.example.mvvm003

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //       val editText: EditText = findViewById(R.id.main_edit)

        val firstNum: TextView = findViewById(R.id.main_text)
        val secondNum: TextView = findViewById(R.id.second_text)
        val operator:TextView =findViewById(R.id.operator_text)
        val resolt:TextView = findViewById(R.id.resolt)



//        editText.doAfterTextChanged {
//            viewModel.onInputChange(it.toString())
//        }
//
//        viewModel.liveData.observe(this, { firstNum.text = it.str })


        //Buttons calculate
        //Buttons number
        val num1 = findViewById<Button>(R.id.num1)
        val num2: Button = findViewById(R.id.num2)
        val num3: Button = findViewById(R.id.num3)
        val num4: Button = findViewById(R.id.num4)
        val num5: Button = findViewById(R.id.num5)
        val num6: Button = findViewById(R.id.num6)
        val num7: Button = findViewById(R.id.num7)
        val num8: Button = findViewById(R.id.num8)
        val num9: Button = findViewById(R.id.num9)
        val num0: Button = findViewById(R.id.num0)
        //buttons operation
        val delete: Button = findViewById(R.id.delete)
        val addition: Button = findViewById(R.id.add)
        val subtraction: Button = findViewById(R.id.sub)
        val multiplication: Button = findViewById(R.id.multi)
        val division: Button = findViewById(R.id.division)
        val equal: Button = findViewById(R.id.equal)
        val clear:Button =findViewById(R.id.initCalculate)


        var str1 = "0"
        var str2 = "0"
        var text1IsFull = false


        fun buttonOfCalculate(button: Button) {
            if (!text1IsFull) {
                str1 += button.text.toString()
                firstNum.text = str1
            } else {
                str2 += button.text.toString()
                secondNum.text = str2
            }
        }

        fun operatCalculete(button: Button) {
                operator.text = button.text
        }
        fun delete(){
            if (text1IsFull) {
                if (str2 != "") {

                    var temp = str2
                    temp = str2.subSequence(1, str2.length) as String
                    str2 = temp
                    secondNum.text = str2
                } else
                    Toast.makeText(this, "number 2 is empti", Toast.LENGTH_SHORT).show()
            } else {
                if (str1 != "") {
                    var temp = ""
                    temp = str1.subSequence(1, str1.length) as String
                    str1 = temp
                    firstNum.text = str1
                } else
                    Toast.makeText(this, "number 1 is empti", Toast.LENGTH_SHORT).show()
            }
        }

        fun equalOfCalculate(str1: String, str2: String, operator: String) {
            if (str1 != "" && str2 != "" ) {
                when (operator) {
                    "+" -> resolt.text = (str1.toInt() + str2.toInt()).toString()
                    "-" -> resolt.text = (str1.toInt() - str2.toInt()).toString()
                    "*" -> resolt.text = (str1.toInt() * str2.toInt()).toString()
                    "/" -> resolt.text = (str1.toInt() / str2.toInt()).toString()
                    "%" -> resolt.text = (str1.toInt() / 100).toString()
                }
            }else if(str1 != ""){
                if (operator == "%")
                    resolt.text = (str1.toInt() / 100).toString()
            }else{
                Toast.makeText(this, "pleas full numbers!!!!", Toast.LENGTH_SHORT).show()
            }

        }

//on click num
        num0.setOnClickListener { buttonOfCalculate(num0) }
        num1.setOnClickListener { buttonOfCalculate(num1) }
        num2.setOnClickListener { buttonOfCalculate(num2) }
        num3.setOnClickListener { buttonOfCalculate(num3) }
        num4.setOnClickListener { buttonOfCalculate(num4) }
        num5.setOnClickListener { buttonOfCalculate(num5) }
        num6.setOnClickListener { buttonOfCalculate(num6) }
        num7.setOnClickListener { buttonOfCalculate(num7) }
        num8.setOnClickListener { buttonOfCalculate(num8) }
        num9.setOnClickListener { buttonOfCalculate(num9) }

//on click operation
        equal.setOnClickListener {
                equalOfCalculate(str1, str2, operator = operator.text.toString())
        }


        delete.setOnClickListener {
            delete()
        }

        addition.setOnClickListener { operatCalculete(addition) }
        subtraction.setOnClickListener { operatCalculete(subtraction) }
        multiplication.setOnClickListener { operatCalculete(multiplication) }
        division.setOnClickListener { operatCalculete(division) }
        clear.setOnClickListener {}

        secondNum.setOnClickListener { text1IsFull = true }
        firstNum.setOnClickListener { text1IsFull = false }



    }


}

