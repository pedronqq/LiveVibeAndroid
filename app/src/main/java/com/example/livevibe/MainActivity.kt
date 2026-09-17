package com.example.livevibe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.livevibe.ui.theme.LiveVibeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LiveVibeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

package com.example.livevibe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.livevibe.ui.screen.HomeScreen // Importe a sua tela aqui
import com.example.livevibe.ui.theme.LiveVibeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LiveVibeTheme {
                // Chame a HomeScreen aqui dentro
                HomeScreen()
            }
        }
    }
}

// ------------------------------------------
// 📱 AQUI COMEÇA A SUA INTERFACE (COMO NO SWIFTUI)
// ------------------------------------------

@Composable
fun LiveVibeHome() {
    // Column = VStack
    // Modifier = A forma de adicionar paddings, cores e tamanhos
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)), // Fundo Dark Mode
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Text = Text
        Text(
            text = "LiveVibe",
            color = Color(0xFF8A32FC), // O seu Roxo Neon (0xFF substitui o # do Hex)
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "O seu diário oficial de fã",
            color = Color.LightGray,
            fontSize = 16.sp
        )
    }
}

// Isso aqui é equivalente ao #Preview do Xcode
@Preview(showBackground = true)
@Composable
fun LiveVibeHomePreview() {
    LiveVibeTheme {
        LiveVibeHome()
    }
}
