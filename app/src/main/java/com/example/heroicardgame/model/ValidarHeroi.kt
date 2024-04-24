package com.example.heroicardgame.model

class ValidarHeroi {

    fun camposEmBranco(nomeHeroi : String, atk: String, def: String) : Boolean{
        return nomeHeroi.isEmpty() || atk.isEmpty() || def.isEmpty()
    }

    fun valorAtkInvalido(atk: Int) : Boolean {
        return atk < 0 || atk > 100
    }

    fun valorDefInvalido(def: Int) : Boolean {
        return def < 0 || def > 100
    }

}