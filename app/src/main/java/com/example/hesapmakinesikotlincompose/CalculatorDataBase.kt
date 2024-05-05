    package com.example.hesapmakinesikotlincompose

    import android.content.Context
    import androidx.room.Database
    import androidx.room.Room
    import androidx.room.RoomDatabase
    import kotlinx.coroutines.InternalCoroutinesApi
    import kotlinx.coroutines.internal.synchronized
    import com.example.hesapmakinesikotlincompose.CalculatorDao as CalculatorDao1

    @Database(entities = arrayOf(CalculatorData::class), version = 1)
    abstract class CalculatorDataBase : RoomDatabase() {

        abstract fun calculatorDao(): CalculatorDao1

        //Singleton
        companion object{
            @Volatile private var instance:CalculatorDataBase?=null

            private val lock = Any()

            @OptIn(InternalCoroutinesApi::class)
            operator fun invoke(context: Context)= instance?: synchronized(lock){
                instance ?: makeDatabase(context).also {
                    instance=it
                }
            }

            private fun makeDatabase(context : Context) = Room.databaseBuilder(
                context = context.applicationContext,CalculatorDataBase::class.java,"calculator"
            ).build()
        }
    }