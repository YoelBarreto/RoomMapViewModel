package com.yoel.roommapviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yoel.roommapviewmodel.data.MarkDao
import com.yoel.roommapviewmodel.ui.ScreenMap
import viewmodel.MarKViewModel
import viewmodel.ViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                val viewModel: MarKViewModel = viewModel(factory = ViewModelFactory(MarkDao))
                ScreenMap(
                    modifier = Modifier.padding(innerPadding),
                    viewmodel = viewModel
                )
            }
        }
    }
}