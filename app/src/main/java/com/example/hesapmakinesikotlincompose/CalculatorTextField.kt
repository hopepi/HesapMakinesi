package com.example.hesapmakinesikotlincompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val calculatorMath = CalculatorMath

@Composable
fun CalTextField() {


    val keyboardOptions = remember { KeyboardOptions.Default.copy(imeAction = ImeAction.Previous) }
    Column {
        Row(horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
            modifier = Modifier
                .background(color = Color(81, 43, 129))){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .heightIn(max = 100.dp)
                    .background(color = Color.Transparent)
            ) {
                TextField(
                    value = calculatorMath.textFieldString,
                    onValueChange = {newValue->
                        if (newValue.all { calculatorMath.Islemler.contains(it.toString()) }) {
                            calculatorMath.setTextFieldString(newValue)
                        } else {
                            println("Yanlış giriş")
                        }
                    },
                    minLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Transparent)
                    ,
                    textStyle = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 35.sp,
                        textAlign = TextAlign.End,
                        color = Color(178, 164, 255)),
                    keyboardOptions = keyboardOptions,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
        }
        resultText(calculatorMath.result.value.toString())
    }
}




@Composable
fun resultText(string: String="Sonuc"){
    Row(horizontalArrangement = Arrangement.Absolute.Right,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(81, 43, 129))){
        Text(text = string, textAlign = TextAlign.End, modifier = Modifier.padding(20.dp), color = Color(234, 219, 200))
    }

}


@Preview
@Composable
fun CalTextFieldPreview(){
    CalTextField()
}