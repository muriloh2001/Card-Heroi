package com.example.heroicardgame.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.heroicardgame.model.Heroi

@Database(entities = [Heroi::class], version = 1)
abstract class HeroiDataBase : RoomDatabase(){

    abstract fun getDAO() : HeroiDAO

    companion object{

        private lateinit var INSTANCE: HeroiDataBase

        fun getInstace(context: Context): HeroiDataBase {

            if(!::INSTANCE.isInitialized){
                INSTANCE = Room.databaseBuilder(context, HeroiDataBase::class.java, "herois_db")
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE
        }

    }

}