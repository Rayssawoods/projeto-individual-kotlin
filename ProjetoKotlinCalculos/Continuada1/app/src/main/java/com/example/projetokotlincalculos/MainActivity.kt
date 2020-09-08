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
            /*Toast.makeText(

                this,
                "$nome, Digite seu nome",
                Toast.LENGTH_LONG
            ).show()*/

            ed_nome.requestFocus()
            IsValid = false
            return IsValid
        }
       return IsValid
    }

    fun validarNota() {
       // val nome: String = ed_nome.getText().toString()
        validarNome()
       if (validarNome().equals(true)) {
           if (ed_nota1.text.toString().toDouble() > 10.0 ||
               ed_nota2.text.toString().toDouble() > 10.0
           ) {
               Toast.makeText(
                   this,
                   "O valor máximo para a nota é 10.0",
                   Toast.LENGTH_LONG
               ).show()

               ed_nota1.requestFocus()
           }
       }

    }


    fun calcularMediaDeDoisNumeros(componente: View) {
        val nome: String = ed_nome.getText().toString()

        if (validarNome()){
            val nota1 = ed_nota1.text.toString().toDouble()
            val nota2 = ed_nota2.text.toString().toDouble()

            val media = (nota1 + nota2) / 2

            if (media > 5) {
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





        //--------------------------------------------------------------------

       /* when{

            media < 5-> {

                tv_media.text = "$nome, sua média é $media. Classificação: REPROVADO! :( Estude Mais."
                tv_media.setTextColor(Color.parseColor("FF0000"))

            }else ->{
            if( nota1 > 10.0 || nota2 > 10.0){
                Toast.makeText(this, "$nome, o valor máximo para a nota é 10.0", Toast.LENGTH_LONG).show()
                //tv_media.text = "$nome, o valor máximo para a nota é 10.0"
                //tv_media.setTextColor(Color.MAGENTA)

                //ed_nota1.setText(" ")
                ed_nota1.requestFocus()

                //ed_nota2.setText(" ")

            }else {
                tv_media.text = "$nome, sua média é $media. Classificação: APROVADO! :D Parabéns."
                tv_media.setTextColor(Color.parseColor("#03BB85"))

            }
            }
        }*/
