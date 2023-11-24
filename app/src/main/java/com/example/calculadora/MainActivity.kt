package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var tvSinal: TextView
    lateinit var tvNumber1: EditText
    lateinit var tvNumber2: EditText
    lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvSinal = findViewById<TextView>(R.id.tv_sinal)
        tvNumber1 = findViewById<EditText>(R.id.etn_number1)
        tvNumber2 = findViewById<EditText>(R.id.etn_number2)
        tvResult = findViewById<TextView>(R.id.tvResult)

    }

    public fun buttonSomaClick(view: View) {
        tvSinal.text = "+"
        this.operacao("+")
    }

    public fun buttonSubClick(view: View) {
        tvSinal.text = "-"
        this.operacao("-")
    }

    public fun buttonMultClick(view: View) {
        tvSinal.text = "x"
        this.operacao("*")
    }

    public fun buttonDivClick(view: View) {
        tvSinal.text = "÷"
        this.operacao("/")
    }

    public fun buttonClearClick(view: View) {
        tvSinal.text = ""
        tvResult.text = ""
        tvNumber1.setText("")
        tvNumber2.setText("")
    }

    public fun operacao(sinal:String){
        var result = 0.0
        try {
            if (sinal.equals("+")) {
                result = tvNumber1.text.toString().toDouble() + tvNumber2.text.toString().toDouble()
            } else if (sinal.equals("-")) {
                result = tvNumber1.text.toString().toDouble() - tvNumber2.text.toString().toDouble()
            } else if (sinal.equals("*")) {
                result = tvNumber1.text.toString().toDouble() * tvNumber2.text.toString().toDouble()
            } else if (sinal.equals("/")) {
                if( tvNumber2.text.toString().toDouble() == 0.0){
                    Toast.makeText(this, "Não é permitido dividir por 0!", Toast.LENGTH_SHORT).show()
                }
                else {
                    result =
                        tvNumber1.text.toString().toDouble() / tvNumber2.text.toString().toDouble()
                }
            }
            tvResult.text = result.toString()
        }
        catch (e:Exception){
            Toast.makeText(this, "Insira um número", Toast.LENGTH_SHORT).show()
        }
    }
}