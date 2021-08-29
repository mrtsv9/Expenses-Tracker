package com.example.expensestracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class AccountEntity(

    @PrimaryKey(autoGenerate = false)
    val name: String,
    val image: Int?,
    var balance: Int?
)
