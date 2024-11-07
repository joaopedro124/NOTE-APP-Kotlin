

package com.notasdojoao

import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.LinearLayout
import android.os.Bundle

import java.util.Date
import java.text.SimpleDateFormat

public class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Definir o layout relativo
        val layout_relativo = findViewById<RelativeLayout>(R.id.layoutRelativo)
        
        // Definir o layout linear
        val layout_linear = findViewById<LinearLayout>(R.id.layoutLinear)
        layout_linear.orientation = LinearLayout.VERTICAL
        
        // Definir o botao de criar nova nota
        val button_new = Button(this)
        button_new.text = "Criar nova nota"
        button_new.layoutParams = RelativeLayout.LayoutParams(
            220,
            220
        ).apply {
            bottomMargin = 100
            rightMargin = 100
            addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
            addRule(RelativeLayout.ALIGN_PARENT_END)
        }
        
        // Função de adicionar notas
        button_new.setOnClickListener {
        
            //   Layout   //
            val layout_nota = LinearLayout(this)
            layout_nota.orientation = LinearLayout.HORIZONTAL
            layout_nota.setBackgroundColor(Color.parseColor("#222222"))
            layout_nota.gravity = Gravity.CENTER
            layout_nota.layoutParams = LinearLayout.LayoutParams(
               LinearLayout.LayoutParams.MATCH_PARENT,
               LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply{
               bottomMargin = 5
               topMargin = 5
            }
            
            
            //   EditText   //
            val field_nota = EditText(this)
            
            val data_atual = Date()                                      // Data
            val data_formato = SimpleDateFormat("dd/MM/yyyy - hh:mm:ss") // Data
            val data_formatada = data_formato.format(data_atual)         // Data
            
            field_nota.setText("$data_formatada - TÍTULO \n\n")
            
            field_nota.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                weight = 1000f
            }
            
            
            //  Button Remove  //
            val button_remove = Button(this)
            button_remove.text = "X"
            button_remove.layoutParams = LinearLayout.LayoutParams (
                130,
                130
            ).apply {
                weight = 0.1f
            }
            
            // Função de remover notas
            button_remove.setOnClickListener {
                layout_linear.removeView(layout_nota)
            }
            
            // Adicionar tudo ao LinearLayout
            layout_nota.addView(field_nota)
            layout_nota.addView(button_remove)
            layout_linear.addView(layout_nota, 0)
        }
        
        // Coloca as coisas na tela
        layout_relativo.addView(button_new)
    }
}
