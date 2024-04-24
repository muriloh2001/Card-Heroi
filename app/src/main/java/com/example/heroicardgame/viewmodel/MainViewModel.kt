package com.example.heroicardgame.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.heroicardgame.model.Heroi
import com.example.heroicardgame.repository.HeroiRepository

class MainViewModel(application: Application): AndroidViewModel(application) {

    private var repository = HeroiRepository(application.applicationContext)
    private var listViewModel = MutableLiveData<List<Heroi>>()
    private var txtToast = MutableLiveData<String>()

    fun getListViewModel() : LiveData<List<Heroi>>{
        return listViewModel
    }

    fun getTxtToast() : LiveData<String>{
        return txtToast
    }

    fun getListFromDB() {
        listViewModel.value = repository.getAll()
    }

    fun deletar(heroi: Heroi){
        repository.deletar(heroi)
        txtToast.value = "Herói excluído!"
    }

}