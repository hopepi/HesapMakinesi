package com.example.hesapmakinesikotlincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider


class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        setContent {
            MainScreen()
        }
    }
    @Composable
    fun MainScreen(){
        Column (modifier = Modifier
            .fillMaxSize()
            .background(Color(81, 43, 129))
        ){
            CalTextField()
            Column (modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround
            ){
                Spacer(modifier = Modifier.size(70.dp))
                CalBarTest(viewModel = viewModel)
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(Color(16, 44, 87)))
                NumButtonTest(viewModel = viewModel)
            }
        }
    }
    @Preview
    @Composable
    fun MainScreenPreview(){
        MainScreen()
    }
}

