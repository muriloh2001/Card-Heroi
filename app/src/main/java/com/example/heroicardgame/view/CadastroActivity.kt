package com.example.heroicardgame.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.heroicardgame.R
import com.example.heroicardgame.databinding.ActivityCadastroBinding
import com.example.heroicardgame.model.Heroi
import com.example.heroicardgame.viewmodel.CadastroViewModel

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private lateinit var viewModel: CadastroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CadastroViewModel::class.java)

        setObservers()

        binding.btnSalvar.setOnClickListener {

            val nomeHeroi = binding.edtNomeHeroi.text.toString()
            val atk = binding.edtAtk.text.toString()
            val def = binding.edtDef.text.toString()


            if(viewModel.salvar(nomeHeroi, atk, def)){
                finish()
            }

        }


    }

    fun setObservers(){
        viewModel.getTxtToast().observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}