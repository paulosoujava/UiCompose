package com.paulo.uicomposes

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.compose.rememberNavController
import com.paulo.uicomposes.bottomNavigation.MainScreen
import com.paulo.uicomposes.navigation.SetupNavGraph
import com.paulo.uicomposes.ui.components.*
import com.paulo.uicomposes.ui.textfields.CustomOutlineTextField
import com.paulo.uicomposes.ui.theme.UiComposesTheme
import com.paulo.uicomposes.welcome.Welcome

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiComposesTheme {
                  Welcome()
            }
        }
    }
}

@Composable
fun SelectedItem() {
    var selected by remember { mutableStateOf(false) }
    var selected2 by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SelectableItem(selected = selected, title = "Title 1") {
            selected = !selected
        }
        Spacer(modifier = Modifier
            .height(12.dp))
        SelectableItem(
            selected = selected2,
            title = "Title 1",
            subtitle = "Lorem Ipsu Lorem Ipsu Lorem Ipsu Lorem IpsuLorem Ipsu Lorem IpsuLorem Ipsu Lorem IpsuLorem Ipsu Lorem IpsuLorem Ipsu Lorem IpsuLorem Ipsu Lorem IpsuLorem Ipsu Lorem IpsuLorem Ipsu Lorem Ipsu"
        ) {
            selected2 = !selected2
        }
    }
}

@Composable
fun Shimmer() {
    Column {
        repeat(7) {
            AnimatedShimmer()
        }
    }
}

@Composable
fun ShowForm() {

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()

    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confPassword by rememberSaveable { mutableStateOf("") }

    var validateName by rememberSaveable { mutableStateOf(true) }
    var validateSurname by rememberSaveable { mutableStateOf(true) }
    var validateEmail by rememberSaveable { mutableStateOf(true) }
    var validatePhone by rememberSaveable { mutableStateOf(true) }
    var validatePassword by rememberSaveable { mutableStateOf(true) }
    var validateConfPassword by rememberSaveable { mutableStateOf(true) }
    var validateConfEqual by rememberSaveable { mutableStateOf(true) }
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }
    var isConfirmPasswordVisible by rememberSaveable { mutableStateOf(false) }

    val validateErrorName = "Please, input a valid name"
    val validateErrorSurName = "Please, input a valid surname"
    val validateErrorEmail = "Please, input a valid email"
    val validateErrorPhone = "The format of the phone number doesn't seem right"
    val validateErrorPassword =
        "Must mix capital and non-capital letters, a numer, special character and a minimum length of 8"
    var validateErrorEqualPassword = "Password must be equal"

    fun validateData(
        name: String,
        surname: String,
        email: String,
        password: String,
        confirmPassword: String,
    ): Boolean {
        val passwordRegex =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$".toRegex()

        validateName = name.isNotEmpty()
        validateSurname = surname.isNotBlank()
        validateEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        validatePhone = Patterns.PHONE.matcher(phone).matches()
        validatePassword = passwordRegex.matches(password)
        validateConfPassword = passwordRegex.matches(confPassword)
        validateConfEqual = password == confPassword

        return validateName && validateSurname && validateEmail && validatePhone && validatePassword && validateConfPassword && validateConfEqual
    }

    fun register(
        name: String,
        surname: String,
        email: String,
        password: String,
        confirmPassword: String,
    ) {
        if (!validateData(
                name = name,
                surname = surname,
                email = email,
                password = password,
                confirmPassword = confirmPassword,
            )
        ) {
            Toast.makeText(context, "Please review fields", Toast.LENGTH_SHORT).show()
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Register to our App",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(vertical = 20.dp),
            color = Color.Blue
        )

        CustomOutlineTextField(
            value = name,
            onValueChange = { name = it },
            label = "Name",
            showError = !validateName,
            errorMessage = validateErrorName,
            leadingIconImageVector = Icons.Default.PermIdentity,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )
        CustomOutlineTextField(
            value = surname,
            onValueChange = { surname = it },
            label = "Surname",
            showError = !validateSurname,
            errorMessage = validateErrorSurName,
            leadingIconImageVector = Icons.Default.PermIdentity,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )
        CustomOutlineTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            showError = !validateEmail,
            errorMessage = validateErrorEmail,
            leadingIconImageVector = Icons.Default.Email,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )
        CustomOutlineTextField(
            value = phone,
            onValueChange = { phone = it },
            label = "Phone",
            showError = !validatePhone,
            errorMessage = validateErrorPhone,
            leadingIconImageVector = Icons.Default.Phone,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )
        CustomOutlineTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            showError = !validatePassword,
            errorMessage = validateErrorPassword,
            isPasswordField = true,
            isPasswordFieldVisible = !isPasswordVisible,
            onVisibilityChange = { isPasswordVisible = it },
            leadingIconImageVector = Icons.Default.Password,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )
        CustomOutlineTextField(
            value = confPassword,
            onValueChange = { confPassword = it },
            label = "Conf Password",
            showError = !validateConfPassword || !validateConfEqual,
            errorMessage = if (!validateConfPassword) validateErrorEmail else validateErrorEqualPassword,
            isPasswordField = true,
            isPasswordFieldVisible = isConfirmPasswordVisible,
            onVisibilityChange = { isConfirmPasswordVisible = it },
            leadingIconImageVector = Icons.Default.Password,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        Button(
            onClick = {
                register(
                    name, surname, email, password, confPassword
                )
            },
            modifier = Modifier
                .padding(20.dp)
                .fillMaxHeight(0.09f),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Register",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ShowButton() {
    GradientButton(
        text = "Text", textColor = Color.Black, gradient = Brush.verticalGradient(
            colors = listOf(
                Color.Green,
                Color.Black,
                Color.White
            )
        )
    ) {

    }
}

@Composable
fun ShowBottomNavigation() {
    MainScreen()
}

@Composable
fun ShowLoading() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoadingAnimation()
    }
}

@Composable
fun ShowSplash() {
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShowExpandableCard() {
    Column() {
        for (i in 1..10) {
            ExpandableCard(
                title = "Test $i",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                        "\n" +
                        "Why do we use it?\n" +
                        "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n" +
                        "\n"
            )
        }
    }
}
