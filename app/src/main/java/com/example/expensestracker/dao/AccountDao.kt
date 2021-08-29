package com.example.expensestracker.dao

import androidx.room.*
import com.example.expensestracker.database.AccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAccount(account: AccountEntity)

    @Delete
    suspend fun deleteAccount(account: AccountEntity)

    @Query("SELECT * FROM accounts ORDER BY name ASC")
    fun readAllData(): Flow<List<AccountEntity>>



}