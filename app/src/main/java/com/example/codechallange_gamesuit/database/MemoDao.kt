package com.example.codechallange_gamesuit.database

import androidx.room.*

@Dao
interface MemoDao {
    @Query("SELECT * FROM Memo")
    fun getAll(): List<Memo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(memo: Memo): Long

    @Delete
    fun delete(memo: Memo): Int

    @Update
    fun update(memo: Memo): Int
}