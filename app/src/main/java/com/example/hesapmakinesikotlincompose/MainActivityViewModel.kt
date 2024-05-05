package com.example.hesapmakinesikotlincompose

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
class MainActivityViewModel(application: Application) : BaseViewModel(application) {

    private val _calculatorData = MutableLiveData<List<CalculatorData>>()
    val calculatorData: LiveData<List<CalculatorData>> get() = _calculatorData

    private val dao = CalculatorDataBase(getApplication()).calculatorDao()

    fun storeInSQLite(list : List<CalculatorData>) {
        launch {
            dao.deleteAllCalculatorData()
            val listLong = dao.insertAll(*list.toTypedArray())
            var i = 0
            while (i < list.size) {
                list[i].uuid = listLong[i].toInt()
                i++
            }
            getDataFromSQLite()
            println("Veriler veritabanına başarıyla eklendi.")
        }
    }

    fun getDataFromSQLite() {
        launch {
            val calculatorDataList = dao.getAllCalculatorData()
            _calculatorData.postValue(calculatorDataList)
            println("Veriler veritabanından başarıyla çekildi.")
        }
    }

    fun insertDataToDatabase(dataList: List<CalculatorData>) {
        storeInSQLite(dataList)
    }
    fun loadDataFromSQLite() {
        launch {
            val data = getDataFromSQLite()
            // Burada verileri kullanabilirsiniz
        }
    }
}

