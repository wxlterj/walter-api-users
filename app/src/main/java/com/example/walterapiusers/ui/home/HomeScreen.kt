package com.example.walterapiusers.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.walterapiusers.R
import com.example.walterapiusers.ui.theme.WalterApiUsersTheme

@Composable
fun HomeScreen(
    onRegistrerClicked: () -> Unit = {},
    onGetUserClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.home_question),
            modifier = Modifier.padding(bottom = 20.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )
        Buttons(
            onRegistrerClicked = onRegistrerClicked,
            onGetUserClicked = onGetUserClicked,
            modifier = Modifier.padding(vertical = 32.dp)
        )
        Text(text = stringResource(R.string.home_screen_text_footer))
    }
}

@Composable
fun Buttons(
    onRegistrerClicked: () -> Unit,
    onGetUserClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = onRegistrerClicked,
            modifier = Modifier
                .widthIn(min = 176.dp)
                .height(68.dp)
        ) {
            Text(text = stringResource(R.string.register_a_new_user))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onGetUserClicked,
            modifier = Modifier
                .widthIn(min = 176.dp)
                .height(68.dp)
        ) {
            Text(text = stringResource(R.string.get_user))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    WalterApiUsersTheme {
        HomeScreen()
    }
}

