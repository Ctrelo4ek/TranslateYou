package com.bnyro.translate

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.bnyro.translate.models.MainModel
import com.bnyro.translate.ui.LanguageSelector
import com.bnyro.translate.ui.StyledTextField
import com.bnyro.translate.ui.theme.TopBar
import com.bnyro.translate.ui.theme.TranslateYouTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TranslateYouTheme {
                ScreenContent()
            }
        }
        ViewModelProvider(this)[MainModel::class.java].translate()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenContent() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar()
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    Card(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1.0f)
            ) {
                StyledTextField(
                    modifier = Modifier
                        .padding(0.dp, 50.dp, 0.dp, 0.dp)
                )
                StyledTextField(
                    readOnly = true
                )
            }
            Row {
                LanguageSelector()
                LanguageSelector()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}