package com.example.letras2

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var txt: EditText
    lateinit var checkNegritas: CheckBox
    lateinit var checkCursiva: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt = findViewById(R.id.ednombre)
        checkNegritas = findViewById(R.id.chkNegrita)
        checkCursiva = findViewById(R.id.chkCursiva)

        // Configurar los listeners para los checkbox
        checkNegritas.setOnCheckedChangeListener { _, _ -> actualizarEstilo() }
        checkCursiva.setOnCheckedChangeListener { _, _ -> actualizarEstilo() }
    }

    private fun actualizarEstilo() {
        var estilo = Typeface.NORMAL
        if (checkNegritas.isChecked && checkCursiva.isChecked) {
            estilo = Typeface.BOLD_ITALIC
        } else if (checkNegritas.isChecked) {
            estilo = Typeface.BOLD
        } else if (checkCursiva.isChecked) {
            estilo = Typeface.ITALIC
        }
        txt.setTypeface(null, estilo)
    }

    fun ClickCheck(v: View) {
        Log.e("CheckBox", "Se presionó")
        actualizarEstilo()
    }
}


