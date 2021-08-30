package com.example.expensestracker.dao

import androidx.room.*
import com.example.expensestracker.database.TransactionEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTransaction(transaction: TransactionEntity)

    @Query("SELECT * FROM transactions ORDER BY category ASC")
    fun readAllData() : Flow<List<TransactionEntity>>

}