package com.example.projeto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.projeto1.databinding.ActivityMainBinding
import com.example.projeto1.viewmodels.main_view_model

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    //lateinit var viewModel: main_view_model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val activityForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            when(it.resultCode){
                RESULT_OK->{
                    Toast.makeText(this, "Configurações Atualizadas!!", Toast.LENGTH_SHORT).show()
                }
                RESULT_CANCELED -> {
                    Toast.makeText(this, "Voltando", Toast.LENGTH_SHORT).show()
                }
            }
        }

      binding.buttonConfiguracoes.setOnClickListener {
           val intent = Intent(this, tela_configuracao::class.java)
           intent.putExtra("game", "")
           activityForResult.launch(intent)
      }


    }


}