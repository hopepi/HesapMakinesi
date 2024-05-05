    package com.example.hesapmakinesikotlincompose

    import androidx.room.ColumnInfo
    import androidx.room.Entity
    import androidx.room.PrimaryKey

    @Entity
    data class CalculatorData (
        @ColumnInfo(name="process")
        val calculatorProcess :String,
        @ColumnInfo(name="result")
        val calculatorResult :String
    ){
        @PrimaryKey(autoGenerate = true)
        var uuid : Int = 0
    }