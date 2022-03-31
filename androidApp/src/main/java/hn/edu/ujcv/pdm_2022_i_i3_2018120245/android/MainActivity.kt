package hn.edu.ujcv.pdm_2022_i_i3_2018120245.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import hn.edu.ujcv.pdm_2022_i_i3_2018120245.Greeting

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
        llenarSpinner()
    }


    fun llenarSpinner(){

        var lista = listOf("Seleccione","Lb a Kg","Kg a Lb")

        val spn: Spinner = findViewById(R.id.spnConversion)

        val adaptador3 = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista)
        spn.adapter = adaptador3

    }



    fun Convertir(view: android.view.View) {
        val spn: Spinner = findViewById(R.id.spnConversion)
        val numero: EditText = findViewById(R.id.txtCantidad)
        val resultado: TextView = findViewById(R.id.txtResultado)
        var calculo = 0.0

        if (spn.selectedItem.toString().equals("Lb a Kg") && numero.text.trim().isNotEmpty()){
            calculo = numero.text.toString().toDouble()*0.453592
            resultado.setText(String.format("%.2f",calculo)+" Kg")

        }else if (spn.selectedItem.toString().equals("Kg a Lb") && numero.text.trim().isNotEmpty()){
            calculo = numero.text.toString().toDouble()*2.20462
            resultado.setText(String.format("%.2f",calculo)+" Lb")

        }else if (spn.selectedItem.toString().equals("Seleccione")){
            Toast.makeText(this, "Debe de seleccionar la conversión", Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this, "Debe de ingresar el dato a convertir", Toast.LENGTH_SHORT).show()
        }
    }
}
