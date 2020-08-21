package com.example.codechallange_gamesuit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version = 1)
abstract class DatabaseMemo : RoomDatabase() {
    abstract fun memoDao() : MemoDao

    companion object {
        private var INSTANCE: DatabaseMemo? = null

        fun getInstance(context: Context): DatabaseMemo? {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    DatabaseMemo::class.java,
                    "item_db").build()
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}