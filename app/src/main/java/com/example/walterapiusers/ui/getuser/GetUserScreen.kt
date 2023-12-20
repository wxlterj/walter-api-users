package com.example.walterapiusers.ui.getuser

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.walterapiusers.R
import com.example.walterapiusers.ui.theme.WalterApiUsersTheme

@Composable
fun GetUserScreen(
    firsName: String,
    lastName: String,
    email: String,
    phoneNumber: String,
    onEditClicked: () -> Unit,
    onDeleteClicked: () -> Unit,
    viewModel: GetUserViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.get_user_screen_title),
            modifier = Modifier,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(32.dp))
        UserCard(
            firsName = firsName,
            lastName = lastName,
            email = email,
            phoneNumber = phoneNumber
        )
        Spacer(modifier = Modifier.height(26.dp))
        GetUserButtons(onEditClicked = onEditClicked,
            onDeleteClicked = {
                onDeleteClicked()
                viewModel.onDeletePressed()
            }
        )
        if (uiState.isDeleteButtonPressed) {
            AlertDialog(
                onDismissRequest = { viewModel.onDismiss() },
                confirmButton = {
                    TextButton(onClick = { }) {
                        Text(text = stringResource(R.string.Delete))
                    }
                },
                dismissButton = {
                    TextButton(onClick = { viewModel.onDismiss() }) {
                        Text(text = stringResource(R.string.dismiss))
                    }
                },
                title = {
                    Text(text = stringResource(R.string.delete_user))
                },
                properties = DialogProperties()
            )
        }
    }
}

@Composable
fun UserCard(
    firsName: String,
    lastName: String,
    email: String,
    phoneNumber: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(horizontal = 32.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        border = BorderStroke(width = 1.dp, Color.Black),
    ) {
        Column(
            modifier = modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UserLabel(label = R.string.first_name, info = firsName)
            UserLabel(label = R.string.last_name, info = lastName)
            UserLabel(label = R.string.email, info = email)
            UserLabel(label = R.string.phone_number, info = phoneNumber)
        }
    }
}

@Composable
fun UserLabel(
    @StringRes label: Int,
    info: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(label),
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = info,
            fontSize = 20.sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun GetUserButtons(
    onEditClicked: () -> Unit,
    onDeleteClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        GetUserButton(
            buttonText = R.string.edit,
            onButtonClicked = onEditClicked,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        GetUserButton(
            buttonText = R.string.Delete,
            onButtonClicked = onDeleteClicked,
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
fun GetUserButton(
    @StringRes buttonText: Int,
    onButtonClicked: () -> Unit,
    color: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onButtonClicked,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(color)
    ) {
        Text(text = stringResource(buttonText))
    }
}

@Preview(showSystemUi = true)
@Composable
fun GetUserScreenPreview() {
    WalterApiUsersTheme {
        GetUserScreen(
            firsName = "Walter",
            lastName = "Fernandez",
            email = "oelo@szs.petare",
            phoneNumber = "3564654654",
            onEditClicked = { /*TODO*/ },
            onDeleteClicked = {}
        )
    }
}
