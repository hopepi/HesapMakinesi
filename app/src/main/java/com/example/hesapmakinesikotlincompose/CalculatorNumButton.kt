package com.example.hesapmakinesikotlincompose
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider



@Composable
fun NumButtonTest(viewModel :MainActivityViewModel){
    Column (modifier = Modifier
        .background(color = Color(81, 43, 129))
        .padding(10.dp)
    ){
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly){
            Box(modifier = Modifier.weight(1f)){
                NumButton("C", modifier = Modifier
                    .size(90.dp)
                    ,ButtonDefaults.buttonColors(Color(14, 21, 58)),
                    text_color = Color(218, 192, 163),onClick = {
                        buttonClick("C", viewModel = viewModel)
                    })
            }
            Box (modifier = Modifier){
                NumButton("=", modifier = Modifier
                    .size(90.dp)
                    ,ButtonDefaults.buttonColors(Color(14, 21, 58)),
                    text_color = Color(218, 192, 163),onClick = {
                        buttonClick("=", viewModel = viewModel)
                    })
            }
        }



        Row {
            Column (Modifier.weight(1f)){
                Row (horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(81, 43, 129))){
                    NumButton("1", onClick = {
                        buttonClick("1", viewModel = viewModel)
                    })
                    NumButton("2",onClick = {
                        buttonClick("2", viewModel = viewModel)
                    })
                    NumButton("3",onClick = {
                        buttonClick("3", viewModel = viewModel)
                    })
                }
                Row (horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(81, 43, 129))){
                    NumButton("4",onClick = {
                        buttonClick("4", viewModel = viewModel)
                    })
                    NumButton("5",onClick = {
                        buttonClick("5", viewModel = viewModel)
                    })
                    NumButton("6",onClick = {
                        buttonClick("6", viewModel = viewModel)
                    })
                }
                Row (horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(81, 43, 129))){
                    NumButton("7",onClick = {
                        buttonClick("7", viewModel = viewModel)
                    })
                    NumButton("8",onClick = {
                        buttonClick("8", viewModel = viewModel)
                    })
                    NumButton("9",onClick = {
                        buttonClick("9", viewModel = viewModel)
                    })
                }
                Row (horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(81, 43, 129))){
                    NumButton(".",onClick = {
                        buttonClick(".", viewModel = viewModel)
                    })
                    NumButton("0",onClick = {
                        buttonClick("0", viewModel = viewModel)
                    })
                    NumButton("%",colors = ButtonDefaults.buttonColors(Color(32, 22, 88)),
                        onClick = {
                        buttonClick("%", viewModel = viewModel)
                    })
                }
            }
            Column(
                modifier = Modifier
                    .background(color = Color(81, 43, 129)),
                verticalArrangement = Arrangement.SpaceEvenly
            )
            {
                NumButton("/", modifier = Modifier.size(90.dp),
                    ButtonDefaults.buttonColors(Color(32, 22, 88)),onClick = {
                        buttonClick("/", viewModel = viewModel)
                    })
                NumButton("x", modifier = Modifier.size(90.dp),
                    ButtonDefaults.buttonColors(Color(32, 22, 88)),onClick = {
                        buttonClick("x", viewModel = viewModel)
                    })
                NumButton("+", modifier = Modifier.size(90.dp),
                    ButtonDefaults.buttonColors(Color(32, 22, 88)),onClick = {
                        buttonClick("+", viewModel = viewModel)
                    })
                NumButton("-", modifier = Modifier.size(90.dp),
                    ButtonDefaults.buttonColors(Color(32, 22, 88)),onClick = {
                        buttonClick("-", viewModel = viewModel)
                    })
            }
        }

    }
}

@Composable
fun NumButton(
    buttonString : String,
    modifier :Modifier=Modifier,
    colors: ButtonColors=ButtonDefaults.buttonColors(Color(53, 21, 93)),
    text_color: Color= Color.White,
    onClick: () -> Unit
)
{

    Button(onClick = onClick,
        modifier
            .padding(4.dp)
            .size(width = 80.dp, height = 83.dp)
            .clip(shape = CircleShape),
        colors = colors
    )
    {
        Text(text = buttonString, style = MaterialTheme.typography.headlineMedium, color = text_color)
    }
}


fun buttonClick(buttonString: String,viewModel: MainActivityViewModel) {
    if (buttonString.equals("C")) {
        calculatorMath.setTextFieldString("")
    } else if (buttonString.equals("=")) {
        calculatorMath.result.value=
            calculatorMath.matematikselislemler(calculatorMath.textFieldString)
        calculatorMath.setTextFieldString(calculatorMath.result.value.toString())
        val calculatorData = CalculatorData(
            calculatorProcess = calculatorMath.textFieldString,
            calculatorResult = calculatorMath.result.value.toString()
        )
        viewModel.insertDataToDatabase(listOf(calculatorData))
    } else {
        calculatorMath.setTextFieldString(calculatorMath.textFieldString + buttonString)
    }
}

