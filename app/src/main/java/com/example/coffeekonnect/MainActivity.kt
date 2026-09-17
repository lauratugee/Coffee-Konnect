package com.example.coffeekonnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeekonnect.ui.theme.CoffeeKonnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeKonnectTheme {
                CoffeeKonnectApp()

                }
            }
        }
}


@Composable
fun CoffeeKonnectApp() {

    var currentScreen by remember {
        mutableStateOf("Welcome")
    }
    when (currentScreen) {

        "welcome" -> {
            CoffeeKonnectWelcomePage(
                onLoginClick = {
                    currentScreen = "login"
                }
            )
        }

        "login" -> {
            LoginPage()
        }
    }
}

@Composable
fun CoffeeKonnectWelcomePage(
    onLoginClick: () -> Unit
){
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .padding(
                    start = 30.dp,
                    end = 30.dp,
                    top =20.dp,
                    bottom =20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
          Text(
              text= "COFFEE KONNECT",
              fontSize = 32.sp,
              fontWeight = FontWeight.Bold,
              textAlign = TextAlign.Center
          )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text= "Linking smallholder coffee farmers across Kenya",
                fontSize = 17.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier=Modifier.height(50.dp))

            Button(
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth()
            ){
            Text(
                text = "Login",
                fontSize = 16.sp

            )
        }
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = {
                    //Registration screen
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text="Register",
                    fontSize = 16.sp
                )
            }


        }
        }

    }




