package com.example.expensestracker.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "accounts")
data class AccountEntity(

    @PrimaryKey(autoGenerate = false)
    val name: String,
    val image: Int?,
    @ColumnInfo(name = "balance")
    var balance: Int?
): Parcelable