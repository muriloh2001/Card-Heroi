package com.example.heroicardgame.repository

import android.content.Context
import com.example.heroicardgame.model.Heroi

class HeroiRepository(context: Context) {

    val dao = HeroiDataBase.getInstace(context).getDAO()

    fun salvar(heroi: Heroi) : Boolean{
        return dao.salvar(heroi) > 0
    }

    fun atualizar(heroi: Heroi) {
        dao.atualizar(heroi)
    }

    fun deletar(heroi: Heroi){
        dao.deletar(heroi)
    }

    fun getHeroi(id: Int): Heroi {
        return dao.getHeroi(id)
    }

    fun getAll() : List<Heroi> {
        return dao.getAll()
    }

}