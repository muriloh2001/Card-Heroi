package com.example.heroicardgame.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.heroicardgame.R
import com.example.heroicardgame.databinding.ActivityHeroiBinding
import com.example.heroicardgame.model.Heroi
import com.example.heroicardgame.viewmodel.HeroiViewModel

class HeroiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroiBinding
    private lateinit var viewModel : HeroiViewModel
    private lateinit var heroi : Heroi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(HeroiViewModel::class.java)

        setObservers()

        val id = intent.getIntExtra("id", 0)

        if(id == 0){
            finish()
        } else {
            viewModel.findHeroi(id)
        }

        binding.btnConfirmar.setOnClickListener{
            val atk  = binding.edtVerAtk.text.toString()
            val def = binding.edtVerDef.text.toString()

            if (viewModel.validarAntesDeAtualizar(heroi.nomeHeroi, atk, def)){
                heroi.atk = atk.toInt()
                heroi.def = def.toInt()
                viewModel.atualizar(heroi)
                finish()
            }

        }



    }
    fun setObservers(){
        viewModel.getHeroiFromDB().observe(this){
            heroi = it
            binding.txtVerNomeHeroi.text = heroi.nomeHeroi
            binding.edtVerAtk.setText(heroi.atk.toString())
            binding.edtVerDef.setText(heroi.def.toString())
        }
        viewModel.getTxtToast().observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}