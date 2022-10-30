package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val equation = findViewById<TextView>(R.id.equation)
        val result = findViewById<TextView>(R.id.result)

        val tvOne = findViewById<TextView>(R.id.one)
        val tvTwo = findViewById<TextView>(R.id.two)
        val tvThree = findViewById<TextView>(R.id.three)
        val tvFour = findViewById<TextView>(R.id.four)
        val tvFive = findViewById<TextView>(R.id.five)
        val tvSix = findViewById<TextView>(R.id.six)
        val tvSeven = findViewById<TextView>(R.id.seven)
        val tvEight = findViewById<TextView>(R.id.eight)
        val tvNine = findViewById<TextView>(R.id.nine)
        val tvZero = findViewById<TextView>(R.id.zero)
        val tvDot = findViewById<TextView>(R.id.dot)
        val tvPlus = findViewById<TextView>(R.id.plus)
        val tvMinus = findViewById<TextView>(R.id.minus)
        val tvMult = findViewById<TextView>(R.id.multiply)
        val tvDiv = findViewById<TextView>(R.id.div)
        val tvPercent = findViewById<TextView>(R.id.percent)
        val tvClear = findViewById<TextView>(R.id.all_clear)
        val tvDel = findViewById<TextView>(R.id.delete)
        val tvEqual = findViewById<TextView>(R.id.equal)
        val tvBrackets = findViewById<TextView>(R.id.brackets)

        tvOne.setOnClickListener{setTextField("1")}
        tvTwo.setOnClickListener{setTextField("2")}
        tvThree.setOnClickListener{setTextField("3")}
        tvFour.setOnClickListener{setTextField("4")}
        tvFive.setOnClickListener{setTextField("5")}
        tvSix.setOnClickListener{setTextField("6")}
        tvSeven.setOnClickListener{setTextField("7")}
        tvEight.setOnClickListener{setTextField("8")}
        tvNine.setOnClickListener{setTextField("9")}
        tvZero.setOnClickListener{setTextField("0")}
        tvDot.setOnClickListener{setTextField(".")}
        tvPlus.setOnClickListener{setTextField("+")}
        tvMinus.setOnClickListener{setTextField("-")}
        tvMult.setOnClickListener{setTextField("*")}
        tvDiv.setOnClickListener{setTextField("/")}
        tvPercent.setOnClickListener{setTextField("%")}

        tvBrackets.setOnClickListener{
            var char1 = 0
            var char2 = 0
            val charAr = equation.text.toString().toCharArray()
            for (element in charAr){
                if (element.toString() == "("){
                    char1++
                }
                if (element.toString() == ")"){
                    char2++
                }
            }
            if (char1 - char2 == 0){
                setTextField("(")
            }else{
                setTextField(")")
            }
        }

        tvClear.setOnClickListener{
            equation.text = ""
            result.text = ""
        }

        tvDel.setOnClickListener{
            val str = equation.text
            if (str.isNotEmpty()){
                equation.text = str.substring(0, str.length - 1)
                result.text = ""
            }
        }


        tvEqual.setOnClickListener{
            try {
                val ex = ExpressionBuilder(equation.text.toString()).build()
                val res = ex.evaluate()

                val longRes = res.toLong()
                if (res == longRes.toDouble()){
                    result.text = longRes.toString()
                }else{
                    result.text = res.toString()
                }
            }catch (e:Exception){
                Log.d("Ошибка", "сообщение ${e.message}")
            }
        }


    }


    fun setTextField (str:String) {
        if (findViewById<TextView>(R.id.result).text != ""){
            findViewById<TextView>(R.id.equation).text = findViewById<TextView>(R.id.result).text
            findViewById<TextView>(R.id.result).text = ""
        }

        findViewById<TextView>(R.id.equation).append(str)

    }
}