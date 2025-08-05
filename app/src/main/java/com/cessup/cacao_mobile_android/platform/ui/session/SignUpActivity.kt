package com.cessup.cacao_mobile_android.platform.ui.session

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.getValue

/**
 * SignUpActivity got the screen about create a new user.
 *
 * @author
 *     Cessup
 * @since 1.0
 */
class SignUpActivity : ComponentActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: SignUpViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)
        enableEdgeToEdge()
        setContent {
            ->
            CacaoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    SignUpScreen(viewModel,it)
                }
            }
        }
    }
}

/**
 * This function is the UI about Sign up
 */
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel,
    paddingValues: PaddingValues
) {
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var nickName by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var birthDateLong by remember { mutableStateOf<Long?>(null) }
    var birthDateDisplay by remember { mutableStateOf("Select Birthdate") }

    val calendar = Calendar.getInstance()

    // Date Picker Dialog
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
            birthDateLong = calendar.timeInMillis
            birthDateDisplay = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                .format(Date(birthDateLong!!))
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

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
            text = "Sign Up",
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField(modifier = Modifier.fillMaxSize(), value = email, onValueChange = { email = it }, label = { Text("Email") })
                OutlinedTextField(modifier = Modifier.fillMaxSize(), value = phone, onValueChange = { phone = it }, label = { Text("Phone") })
                OutlinedTextField(modifier = Modifier.fillMaxSize(), value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())
                OutlinedTextField(modifier = Modifier.fillMaxSize(), value = nickName, onValueChange = { nickName = it }, label = { Text("Nick Name") })
                OutlinedTextField(modifier = Modifier.fillMaxSize(), value = name, onValueChange = { name = it }, label = { Text("Name") })
                OutlinedTextField(modifier = Modifier.fillMaxSize(), value = lastName, onValueChange = { lastName = it }, label = { Text("Last Name") })
                OutlinedTextField(modifier = Modifier.fillMaxSize(), value = address, onValueChange = { address = it }, label = { Text("Address") })
                OutlinedTextField(modifier = Modifier.fillMaxSize(), value = gender, onValueChange = { gender = it }, label = { Text("Gender") })

                // Birthdate picker
                Button(onClick = { datePickerDialog.show() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = birthDateDisplay)
                }

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = {
                        viewModel.signUp(email,phone,password,nickName,name,lastName,address,gender,birthDateLong!!)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                        Text("Register")
                }

            }
        }
    }
}