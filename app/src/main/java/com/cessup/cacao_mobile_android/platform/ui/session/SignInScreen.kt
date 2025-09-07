package com.cessup.cacao_mobile_android.platform.ui.session

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SignInScreen(
    onSignInClick: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    val viewModel: SignInViewModel = hiltViewModel()

    var email by remember { mutableStateOf("") }
    var keyword by remember { mutableStateOf("") }

    val token by viewModel.token.collectAsState()

    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Sign In",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(100.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth(),
                    supportingText = {
                        if (errorMessage != null) {
                            Text(text = errorMessage!!, color = MaterialTheme.colorScheme.error)
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = keyword,
                    onValueChange = { keyword = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    supportingText = {
                        if (errorMessage != null) {
                            Text(text = errorMessage!!, color = MaterialTheme.colorScheme.error)
                        }
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        if (token.isBlank()) {
                            errorMessage = "Field cannot be empty"
                        } else {
                            errorMessage = null
                            onSignInClick(token)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                    Text("Sign In")
                }

                Spacer(modifier = Modifier.height(12.dp))

                TextButton(
                    onClick = onForgotPasswordClick,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    TextButton(
                        onClick = onForgotPasswordClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text("Forgot password?")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(200.dp))

        TextButton(
            onClick = onRegisterClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Don’t have an account? Sign up.")
        }
    }
}
