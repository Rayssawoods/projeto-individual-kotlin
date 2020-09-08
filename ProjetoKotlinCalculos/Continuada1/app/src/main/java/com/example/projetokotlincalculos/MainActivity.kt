package com.example.projetokotlincalculos

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun validarNome(): Boolean {
        val nome: String = ed_nome.getText().toString()
        var IsValid = true;

        if (nome.isEmpty()) {
            ed_nome.error = "Digite o seu nome!"
            ed_nome.requestFocus()

            IsValid = false
            return IsValid
        } else if (nome.length < 3) {
            ed_nome.error = "O nome não pode ter menos de 3 letras!"
            ed_nome.requestFocus()

            IsValid = false
        }
        return IsValid
    }

    fun validarNota(): Boolean {

        validarNome()
        var notaValida = true
        val nota1 = ed_nota1.text.toString().toDouble()
        val nota2 = ed_nota2.text.toString().toDouble()

        if (validarNome().equals(true)) {
            if (nota1 > 10.0 || nota2 > 10.0) {

                Toast.makeText(this, "O valor máximo para a nota é 10.0",
                    Toast.LENGTH_LONG).show()
                 notaValida = false
                ed_nota1.requestFocus()

            }else if (nota1== 0.0 || nota2 == 0.0){
                Toast.makeText(this, "Nota invalida",
                    Toast.LENGTH_LONG).show()
                notaValida = false
            }
        }
        return notaValida
    }

    fun calcularMediaDeDoisNumeros(componente: View) {
        val nome: String = ed_nome.getText().toString()

        if (validarNome() && validarNota() ) {
            val nota1 = ed_nota1.text.toString().toDouble()
            val nota2 = ed_nota2.text.toString().toDouble()

            val media = (nota1 + nota2) / 2

            if (media >= 5.0) {
                validarNota()
                tv_media.text =
                    "$nome, sua média é $media. Classificação: APROVADO! :D Parabéns."
                tv_media.setTextColor(Color.parseColor("#03BB85"))

            } else {
                tv_media.text =
                    "$nome, sua média é $media. Classificação: REPROVADO! :( Estude Mais."
                tv_media.setTextColor(Color.RED)
            }
        }

    }
}



