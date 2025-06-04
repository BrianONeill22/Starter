package com.base.starter.ui.screen.FirstScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(
    firstScreenViewModel: FirstScreenViewModel = viewModel(),
    onNavigateToSecond: () -> Unit // Navigation callback
) {
    val uiState by firstScreenViewModel.uiState.collectAsState()
    var textFieldMessage by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("First Screen")

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = uiState.message,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = textFieldMessage,
            onValueChange = { textFieldMessage = it },
            label = { Text("New Message") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { firstScreenViewModel.updateMessage(textFieldMessage) }) {
            Text("Update Message")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onNavigateToSecond) {
            Text("Go to Second Screen")
        }
    }

}