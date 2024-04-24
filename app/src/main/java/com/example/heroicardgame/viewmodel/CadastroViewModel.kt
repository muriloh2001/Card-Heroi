package com.example.heroicardgame.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.heroicardgame.model.Heroi
import com.example.heroicardgame.model.ValidarHeroi
import com.example.heroicardgame.repository.HeroiRepository

class CadastroViewModel(application: Application): AndroidViewModel(application) {

    private var repository = HeroiRepository(application.applicationContext)
    private var validacao = ValidarHeroi()
    private var txtToast = MutableLiveData<String>()

    fun getTxtToast() : LiveData<String>{
        return txtToast
    }

    fun salvar(nomeHeroi: String, atk: String, def: String) : Boolean {

        if (validacao.camposEmBranco(nomeHeroi, atk, def)){
            txtToast.value = "Preencha todos os campos"
            return false
        }

        // se os campos não estão em branco, crio um heroi a partir dos dados recebidos
        var heroi = Heroi(
            0,
            nomeHeroi,
            atk.toInt(),
            def.toInt()
        )

        if(validacao.valorAtkInvalido(heroi.atk)){
            txtToast.value = "ATK deve estar entre 0 e 100"
            return false
        }

        if(validacao.valorDefInvalido(heroi.def)){
            txtToast.value = "DEF deve estar entre 0 e 100"
            return false
        }

        if (!repository.salvar(heroi)){
            txtToast.value = "Erro ao salvar..."
            return false
        }

        txtToast.value = "Herói salvo!"
        return true
    }

}