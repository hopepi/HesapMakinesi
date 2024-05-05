package com.example.hesapmakinesikotlincompose

import androidx.compose.runtime.mutableStateOf

object CalculatorMath {

    private val _islemler = arrayListOf("+", "-", "x", "/", "=", "%", ".", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
    val array = ArrayList<String>()
    var result = mutableStateOf(0.0)

    val Islemler: List<String>
        get() = _islemler

    private var _textFieldString = mutableStateOf("")
    val textFieldString: String
        get() = _textFieldString.value

    fun setTextFieldString(newValue: String) {
        _textFieldString.value = newValue
    }

    fun matematikselislemler(deger: String): Double {
        // Adım 1: string değişkeni değeri atandı
        // Adım 2: İfadeyi operatörlere ve sayılara ayırmak için split işlemi yapıldı
        val sayilar = deger.split("[%+x/-]".toRegex())// sayilar: ["50", "50", "3"]
        // Adım 3: İfadeden operatörleri filtreleyerek ayıklamak için filter işlemi yapıldı
        val operatorler = deger.filter { it in setOf('x', '/', '%', '+', '-') }.toList()// operatorler: ['+', '*']

        // Adım 4: Değişkenler tanımlandı ve ilk değerler atandı
        var index = 0
        var tempResult = sayilar[index].toDouble()// tempResult: 50.0
        var result = 0.0//İşlem Sonucu

        // Adım 5: While döngüsü başlatıldı, operatörlerin her biri için işlem yapıldı
        while (index < operatorler.size) {
            val operator = operatorler[index]// mevcut işlem alır
            val operand = sayilar[index + 1].toDouble()//mevcut operatörün ardındaki sayıyı

            // Adım 6: İşlem türüne göre geçiş yapıldı, "*" operatörü için çarpma işlemi yapıldı
            if (operator in setOf('x', '/', '%')) {
                tempResult = when (operator) {
                    'x' -> tempResult * operand// tempResult: 50.0 * 3 = 150.0
                    '/' -> tempResult / operand
                    '%' -> yuzdeHesapla(tempResult, operand)
                    else -> throw IllegalArgumentException("Geçersiz operatör: $operator")
                }
            } else {
                // Adım 7: "+" operatörü için toplama işlemi yapıldı
                result += tempResult// result: 50.0 + 150.0 = 200.0
                tempResult = if (operator == '+') {
                    operand
                } else {
                    -operand
                }
            }

            index++// Adım 8: Index artırıldı, sonraki operatöre geçildi
        }
        // Adım 9: Sonuç hesaplandı ve döndürüldü
        return result + tempResult // 200.0 + 50.0 = 250.0
    }

        /*
        İfade: "50+25+32*2+1"
        Sayılar: ["50", "25", "32", "2", "1"]
        Operatörler: ['+', '+', '*', '+']
        Başlangıç Değerleri: index = 0, tempResult = 50.0, result = 0.0


        ---Adım Adım Açıklama örneği---
                İlk Operatör: '+'
                result += tempResult // Sonuç: 50.0
                tempResult = operand // tempResult: 25.0
                İkinci Operatör: '+'
                result += tempResult // Sonuç: 75.0
                tempResult = operand // tempResult: 32.0
                Üçüncü Operatör: '*'
                tempResult *= operand // tempResult: 32.0 * 2 = 64.0
                Dördüncü Operatör: '+'
                result += tempResult // Sonuç: 139.0
                tempResult = operand // tempResult: 1.0
                Döngü Sonlandırıldı ve Sonuç Hesaplandı:
                return result + tempResult // Sonuç: 139.0 + 1.0 = 140.0
        */


    fun yuzdeHesapla(sayi: Double, yuzde: Double): Double {
        return (sayi * yuzde) / 100.0
    }

}