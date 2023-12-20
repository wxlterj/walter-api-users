package com.example.walterapiusers.ui.form

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.walterapiusers.R
import com.example.walterapiusers.ui.theme.WalterApiUsersTheme

@Composable
fun UserForm(
    onRegisterClicked: () -> Unit,
    viewModel: UserFormViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.form_screen_title),
            modifier = Modifier.padding(bottom = 24.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
        )
        FormTextFields(
            firstName = uiState.firstName,
            onFirstNameChanged = { viewModel.onFirstNameChange(it) },
            lastName = uiState.lastName,
            onLastNameChanged = { viewModel.onLastNameChange(it) },
            email = uiState.email,
            onEmailChanged = { viewModel.onEmailChange(it) },
            phoneNumber = uiState.phoneNumber,
            onPhoneNumberChanged = { viewModel.onPhoneNumberChange(it) }
        )
        Button(
            onClick = { viewModel.saveUser() },
            modifier = Modifier.padding(vertical = 12.dp)
        ) {
            Text(text = stringResource(R.string.register))
        }

        if (uiState.isError) {
            AlertDialog(
                onDismissRequest = { viewModel.onDismissRequest() },
                confirmButton = { /*TODO*/ },
                title = { 
                        Text(text = "Error")
                },
                properties = DialogProperties()
            )
        }
    }
}

@Composable
fun FormTextFields(
    firstName: String,
    onFirstNameChanged: (String) -> Unit,
    lastName: String,
    onLastNameChanged: (String) -> Unit,
    email: String,
    onEmailChanged: (String) -> Unit,
    phoneNumber: String,
    onPhoneNumberChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        FormTextField(
            value = firstName,
            onValueChage = { onFirstNameChanged(it) },
            placeholder = R.string.first_name
        )
        FormTextField(
            value = lastName,
            onValueChage = { onLastNameChanged(it) },
            placeholder = R.string.last_name
        )
        FormTextField(
            value = email,
            onValueChage = { onEmailChanged(it) },
            placeholder = R.string.email,
            keyboardType = KeyboardType.Email
        )
        FormTextField(
            value = phoneNumber,
            onValueChage = { onPhoneNumberChanged(it) },
            placeholder = R.string.phone_number,
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Send
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormTextField(
    value: String,
    onValueChage: (String) -> Unit,
    @StringRes placeholder: Int,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = { onValueChage(it) },
        modifier = modifier,
        placeholder = {
            Text(text = stringResource(placeholder))
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction)
    )
}

