package com.example.heroicardgame.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "herois")
data class Heroi (
    @ColumnInfo @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "nome_heroi") var nomeHeroi: String,
    @ColumnInfo var atk: Int,
    @ColumnInfo var def: Int
    )