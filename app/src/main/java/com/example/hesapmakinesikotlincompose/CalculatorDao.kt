package com.example.hesapmakinesikotlincompose

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CalculatorDao {
    @Insert
    suspend fun insertAll(vararg calculatorData: CalculatorData) :List<Long>
        //vararg normalde kaç tane vericemizi bilmediğimiz objelerde kullanılıyor


    @Query("SELECT * FROM CalculatorData")
    suspend fun getAllCalculatorData(): List<CalculatorData>

    @Query("DELETE FROM CalculatorData")
    suspend fun deleteAllCalculatorData()

}