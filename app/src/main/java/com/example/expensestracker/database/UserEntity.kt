package com.example.expensestracker.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey(autoGenerate = false)
    val login: String,
    val password: String
)