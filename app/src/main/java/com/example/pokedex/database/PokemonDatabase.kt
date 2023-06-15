package com.example.pokedex.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [PokemonEntity::class, PokemonDetailEntity::class],
    version = 2,
    exportSchema = false
)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun getPokemonDao(): PokemonDao
    abstract fun getPokemonDetailDao(): PokemonDetailDao
}

private lateinit var INSTANCE: PokemonDatabase

fun getDatabase(context: Context): PokemonDatabase {
    synchronized(PokemonDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                PokemonDatabase::class.java,
                "pokemon_databse"
            ).build()
        }
        return INSTANCE
    }
}