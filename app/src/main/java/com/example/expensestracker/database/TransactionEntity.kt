package com.example.expensestracker.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ProvidedTypeConverter

@Entity(tableName = "transactions")
data class TransactionEntity (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val category: String,
    val account: String,
    val amount: Int

)