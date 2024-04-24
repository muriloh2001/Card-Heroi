package com.example.heroicardgame.repository

import androidx.room.*
import com.example.heroicardgame.model.Heroi

@Dao
interface HeroiDAO {

    @Insert
    fun salvar(heroi: Heroi) : Long

    @Update
    fun atualizar(heroi: Heroi)

    @Delete
    fun deletar (heroi: Heroi)

    @Query("SELECT * FROM herois WHERE id = :id")
    fun getHeroi(id: Int): Heroi

    @Query("SELECT * FROM herois")
    fun getAll() : List<Heroi>


}