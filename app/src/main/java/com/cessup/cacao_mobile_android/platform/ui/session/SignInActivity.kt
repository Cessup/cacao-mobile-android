package com.cessup.cacao_mobile_android.platform.ui.session

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.cessup.cacao_mobile_android.App
import com.cessup.cacao_mobile_android.platform.di.ViewModelFactory
import com.cessup.cacao_mobile_android.platform.ui.theme.CacaoTheme
import jakarta.inject.Inject
import kotlin.getValue

/**
 * SignInActivity got the screen about access to the system.
 *
 * @author
 *     Cessup
 * @since 1.0
 */
class SignInActivity : ComponentActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: SignInViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).appComponent.inject(this)


        enableEdgeToEdge()
        setContent {
            ->
            CacaoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    SignInScreen(viewModel,it)
                }
            }
        }
    }
}

@Composable
fun SignInScreen(
    viewModel: SignInViewModel,
    paddingValues: PaddingValues
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val authResult by viewModel.authResult.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(authResult) {
        authResult.let {
            if(it!=null){
                when {
                    it.isSuccess -> {
                        viewModel.loginAction()
                    }
                    it.isFailure -> {
                        val error = it.exceptionOrNull()
                        // show error message
                        Toast.makeText(context, "Exception: ${error?.message}", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .padding(paddingValues)
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
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { viewModel.access(email, password) },
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
                    onClick = { viewModel.forgotPasswordAction() },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Forgot password?")
                }
            }
        }

        Spacer(modifier = Modifier.height(200.dp))

        TextButton(
            onClick = { viewModel.registerAction() },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Don’t have an account? Sign up.")
        }
    }
}