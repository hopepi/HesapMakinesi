package com.example.hesapmakinesikotlincompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CalBarTest(viewModel: MainActivityViewModel){
    Row (modifier = Modifier
        .background(color = Color(81, 43, 129))
    ){
        CalBar(viewModel = viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalBar(viewModel: MainActivityViewModel){
    val calculatorDataList = viewModel.calculatorData.value
    val calculatorMath = CalculatorMath
    val sheetState= rememberModalBottomSheetState()
    var isSheetsOpen by rememberSaveable {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Transparent),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                isSheetsOpen=true
            }
        ) {
            val painter: Painter = painterResource(id = R.drawable.history)
            Icon(painter = painter, contentDescription = "icon")
        }
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterEnd) {
            IconButton(
                onClick = {
                    // Backspace işlemi
                    calculatorMath.setTextFieldString(calculatorMath.textFieldString.dropLast(1))
                },
                Modifier.size(60.dp)
            ) {
                val painter: Painter = painterResource(id = R.drawable.left_arrows)
                Icon(painter = painter, contentDescription = "icon")
            }
        }
    }

    if (isSheetsOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isSheetsOpen = false }
        ) {
            //veriler yazılacak
        }
    }
}



@Preview
@Composable
fun CalBarPreview(){
}