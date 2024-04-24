package com.example.heroicardgame.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.heroicardgame.model.Heroi
import com.example.heroicardgame.model.ValidarHeroi
import com.example.heroicardgame.repository.HeroiRepository

class HeroiViewModel(application: Application): AndroidViewModel(application) {

    private var repository = HeroiRepository(application.applicationContext)
    private var validacao = ValidarHeroi()
    private var heroiFromDB = MutableLiveData<Heroi>()
    private var txtToast = MutableLiveData<String>()

    fun getHeroiFromDB() : LiveData<Heroi>{
        return heroiFromDB
    }

    fun getTxtToast(): LiveData<String>{
        return txtToast
    }

    fun findHeroi(id: Int){
        heroiFromDB.value = repository.getHeroi(id)
    }


    fun validarAntesDeAtualizar(nomeHeroi: String, atk: String, def: String) : Boolean {
        if (validacao.camposEmBranco(nomeHeroi, atk, def)){
            txtToast.value = "Preencha todos os campos!"
            return false
        }

        if (validacao.valorAtkInvalido(atk.toInt()) || validacao.valorDefInvalido(def.toInt())){
            txtToast.value = "Atk e Def devem estar entre 0 e 100"
            return false
        }

        return true
    }

    fun atualizar(heroi: Heroi){
        repository.atualizar(heroi)
        txtToast.value = "Heroi atualizado!"
    }


}