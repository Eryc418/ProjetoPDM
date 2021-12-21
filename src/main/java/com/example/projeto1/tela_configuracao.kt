package com.example.projeto1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.projeto1.databinding.TelaConfiguracaoBinding
import com.google.gson.Gson


class tela_configuracao:AppCompatActivity(){
    lateinit var binding: TelaConfiguracaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.tela_configuracao)
        binding = DataBindingUtil.setContentView(this, R.layout.tela_configuracao)

        binding.buttonVoltar.setOnClickListener {
            finish()
        }
        binding.buttonSalvar.setOnClickListener {
            val preferences = getSharedPreferences("Preferencia", MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString("facil", binding.radioButton6.text.toString())
            editor.putString("medio", binding.radioButton7.text.toString())
            editor.putString("dificil", binding.radioButton8.text.toString())
            editor.putString("mapa1", binding.radioButton9.text.toString())
            editor.putString("mapa2", binding.radioButton10.text.toString())
            editor.apply()
            var i = Intent()
            setResult(Activity.RESULT_OK, i)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        val preferencias = getSharedPreferences("Preferencia", MODE_PRIVATE)
        binding.radioButton6.text = preferencias.getString("facil", "")
        binding.radioButton7.text = preferencias.getString("medio", "")
        binding.radioButton8.text = preferencias.getString("dificil", "")
        binding.radioButton9.text = preferencias.getString("mapa1", "")
        binding.radioButton10.text = preferencias.getString("mapa2", "")
    }
}