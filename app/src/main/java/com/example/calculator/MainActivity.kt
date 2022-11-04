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
        btn0.setOnClickListener { stf("0") }
        btn1.setOnClickListener { stf("1") }
        btn2.setOnClickListener { stf("2") }
        btn3.setOnClickListener { stf("3") }
        btn4.setOnClickListener { stf("4") }
        btn5.setOnClickListener { stf("5") }
        btn6.setOnClickListener { stf("6") }
        btn7.setOnClickListener { stf("7") }
        btn8.setOnClickListener { stf("8") }
        btn9.setOnClickListener { stf("9") }
        btnPlus.setOnClickListener { stf("+") }
        btnMinus.setOnClickListener { stf("-") }
        btnMultiply.setOnClickListener { stf("*") }
        btnDivide.setOnClickListener { stf("/") }
        btnSign2.setOnClickListener { stf("(") }
        btnSign3.setOnClickListener { stf(")") }
        btnSign1.setOnClickListener { stf(".") }

        btnSign.setOnClickListener {
            mathOperation.text = ""
            resultText.text = ""
        }
        btnBack.setOnClickListener {
            val a = mathOperation.text.toString()
            if (a.isNotEmpty()) mathOperation.text = a.substring(0, a.length-1)
            resultText.text = ""
        }
        btnEq.setOnClickListener {
            try {
                val ex = ExpressionBuilder(mathOperation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble()) resultText.text = longRes.toString()
                else resultText.text = result.toString()
            }catch (e:Exception){
                Log.d("Ошибка", "сообщение ${e.message}")
            }
        }
    }
    private fun stf(str:String){
        if (resultText.text != ""){
            mathOperation.text = resultText.text
            resultText.text = ""
        }
        mathOperation.append(str)
    }
    private val mathOperation: TextView by lazy { findViewById(R.id.math_operation) }
    private val resultText: TextView by lazy { findViewById(R.id.result_text) }
    private val btnSign: TextView by lazy { findViewById(R.id.btn_sign) }
    private val btnSign2: TextView by lazy { findViewById(R.id.btn_sign2) }
    private val btnSign3: TextView by lazy { findViewById(R.id.btn_sign3) }
    private val btnDivide: TextView by lazy { findViewById(R.id.btn_divide) }
    private val btn7: TextView by lazy { findViewById(R.id.btn_7) }
    private val btn8: TextView by lazy { findViewById(R.id.btn_8) }
    private val btn9: TextView by lazy { findViewById(R.id.btn_9) }
    private val btnMultiply: TextView by lazy { findViewById(R.id.btn_multiply) }
    private val btn4: TextView by lazy { findViewById(R.id.btn_4) }
    private val btn5: TextView by lazy { findViewById(R.id.btn_5) }
    private val btn6: TextView by lazy { findViewById(R.id.btn_6) }
    private val btnMinus: TextView by lazy { findViewById(R.id.btn_minus) }
    private val btn1: TextView by lazy { findViewById(R.id.btn_1) }
    private val btn2: TextView by lazy { findViewById(R.id.btn_2) }
    private val btn3: TextView by lazy { findViewById(R.id.btn_3) }
    private val btnPlus: TextView by lazy { findViewById(R.id.btn_plus) }
    private val btnSign1: TextView by lazy { findViewById(R.id.btn_sign1) }
    private val btn0: TextView by lazy { findViewById(R.id.btn_0) }
    private val btnBack: TextView by lazy { findViewById(R.id.btn_back) }
    private val btnEq: TextView by lazy { findViewById(R.id.btn_eq) }

}