package com.example.codechallange_gamesuit.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Memo (
    @PrimaryKey(autoGenerate = true) var id:Int?,
    @ColumnInfo(name = "tanggal") var tanggal:String,
    @ColumnInfo(name = "memo") var memo:String
) : Parcelable