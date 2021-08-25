package com.example.expensestracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey
    val login: String,
    val password: String
)