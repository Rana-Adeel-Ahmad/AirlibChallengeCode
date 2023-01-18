package com.example.arlibtestcode.fragment.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginFragment(
    modifier: Modifier = Modifier,
    onClickToHomeScreen: (String) -> Unit = {}
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.background
    ) {
        Column(modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            var email by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier.padding(16.dp),
                value = email,
                onValueChange = {
                    email = it
                },
                label = { Text(text = "Email") },
                placeholder = { Text(text = "Enter your email.") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email Icon") },
            )

            var password by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier.padding(16.dp),
                value = password,
                onValueChange = {
                    password = it
                },
                visualTransformation = PasswordVisualTransformation(),
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Enter your Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                leadingIcon = { Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "password Icon") },
            )

            Button(onClick = {if(email.isNotEmpty()) onClickToHomeScreen(email)}) {
                Text(text = "LogIn")
            }
        }
    }
}